import { useEffect, useState } from 'react'
import { SearchableRoleSelect } from '../components/SearchableRoleSelect'
import { careerApi, rolesApi } from '../api/career'

export function Profile() {
  const [profile, setProfile] = useState(null)
  const [roles, setRoles] = useState([])
  const [loading, setLoading] = useState(true)
  const [saving, setSaving] = useState(false)
  const [targetRoleId, setTargetRoleId] = useState('')
  const [experienceLevel, setExperienceLevel] = useState('')
  const [extractText, setExtractText] = useState('')
  const [extractFile, setExtractFile] = useState(null)
  const [extracting, setExtracting] = useState(false)

  useEffect(() => {
    Promise.all([careerApi.getProfile(), rolesApi.getAll()])
      .then(([p, r]) => {
        setProfile(p)
        setTargetRoleId(p.targetRoleId || '')
        setExperienceLevel(p.experienceLevel || 'ENTRY')
        setRoles(r)
      })
      .catch(console.error)
      .finally(() => setLoading(false))
  }, [])

  async function handleSave() {
    if (!profile) return
    setSaving(true)
    try {
      const updated = await careerApi.updateProfile({
        targetRoleId: targetRoleId || null,
        experienceLevel,
      })
      setProfile(updated)
    } catch (err) {
      alert(err instanceof Error ? err.message : 'Failed to save')
    } finally {
      setSaving(false)
    }
  }

  async function handleExtract() {
    const hasText = extractText.trim().length > 0
    const hasFile = extractFile != null

    if (!hasText && !hasFile) return

    setExtracting(true)
    try {
      if (hasFile) {
        await careerApi.extractSkillsFromFile(extractFile, 'REPLACE')
        setExtractFile(null)
      } else {
        await careerApi.extractSkills(extractText, 'REPLACE')
        setExtractText('')
      }
      const p = await careerApi.getProfile()
      setProfile(p)
    } catch (err) {
      alert(err instanceof Error ? err.message : 'Extraction failed')
    } finally {
      setExtracting(false)
    }
  }

  async function handleRemoveSkill(id) {
    try {
      await careerApi.removeSkill(id)
      if (profile) setProfile({ ...profile, skills: profile.skills.filter((s) => s.id !== id) })
    } catch (err) {
      alert(err instanceof Error ? err.message : 'Failed to remove')
    }
  }

  if (loading) return <p>Loading profile...</p>

  return (
    <div>
      <h1 style={h1}>Career Profile</h1>

      <section style={section}>
        <h2 style={h2}>Target Role</h2>
        <SearchableRoleSelect
          roles={roles}
          value={targetRoleId}
          onChange={setTargetRoleId}
          placeholder="Select a role"
        />
      </section>

      <section style={section}>
        <h2 style={h2}>Experience Level</h2>
        <select
          value={experienceLevel}
          onChange={(e) => setExperienceLevel(e.target.value)}
          style={select}
        >
          <option value="ENTRY">Entry</option>
          <option value="MID">Mid</option>
          <option value="SENIOR">Senior</option>
        </select>
      </section>

      <button onClick={handleSave} disabled={saving} style={btn}>
        {saving ? 'Saving...' : 'Save profile'}
      </button>

      <section style={section}>
        <h2 style={h2}>Extract skills from resume</h2>
        <p style={{ color: '#64748b', fontSize: 14, marginBottom: 12 }}>
          Paste text below or upload a PDF/Word file.
        </p>
        <textarea
          value={extractText}
          onChange={(e) => {
            setExtractText(e.target.value)
            if (e.target.value) setExtractFile(null)
          }}
          placeholder="Paste your resume text here..."
          style={textarea}
          rows={5}
        />
        <div style={fileRow}>
          <span style={or}>or</span>
          <label style={fileLabel}>
            <input
              type="file"
              accept=".pdf,.doc,.docx"
              onChange={(e) => {
                const f = e.target.files?.[0]
                setExtractFile(f || null)
                if (f) setExtractText('')
                e.target.value = ''
              }}
              style={{ display: 'none' }}
            />
            Upload PDF or Word
          </label>
          {extractFile && (
            <span style={fileName}>
              {extractFile.name}
              <button
                type="button"
                onClick={() => setExtractFile(null)}
                style={clearFile}
              >
                ×
              </button>
            </span>
          )}
        </div>
        <button
          onClick={handleExtract}
          disabled={extracting || (!extractText.trim() && !extractFile)}
          style={btn}
        >
          {extracting ? 'Extracting...' : 'Extract & save skills'}
        </button>
      </section>

      <section style={section}>
        <h2 style={h2}>Your skills ({profile?.skills?.length ?? 0})</h2>
        {profile?.skills?.length ? (
          <ul style={skillList}>
            {profile.skills.map((s) => (
              <li key={s.id} style={skillItem}>
                <span>{s.name}</span>
                <span style={category}>{s.category}</span>
                <button onClick={() => handleRemoveSkill(s.id)} style={removeBtn}>
                  Remove
                </button>
              </li>
            ))}
          </ul>
        ) : (
          <p style={{ color: '#64748b' }}>No skills yet. Extract from resume or add manually.</p>
        )}
      </section>
    </div>
  )
}

const h1 = { fontSize: 24, marginBottom: 24 }
const h2 = { fontSize: 16, marginBottom: 12, fontWeight: 600 }
const section = { marginBottom: 32 }
const select = {
  padding: '10px 12px',
  fontSize: 16,
  border: '1px solid #e2e8f0',
  borderRadius: 8,
  minWidth: 200,
}
const btn = {
  padding: '10px 20px',
  background: '#0f172a',
  color: '#fff',
  border: 'none',
  borderRadius: 8,
  cursor: 'pointer',
  marginBottom: 24,
}
const textarea = {
  width: '100%',
  padding: 12,
  fontSize: 14,
  border: '1px solid #e2e8f0',
  borderRadius: 8,
  marginBottom: 12,
  fontFamily: 'inherit',
}
const fileRow = {
  display: 'flex',
  alignItems: 'center',
  gap: 12,
  marginBottom: 12,
}
const or = { fontSize: 14, color: '#94a3b8' }
const fileLabel = {
  padding: '8px 16px',
  background: '#f1f5f9',
  borderRadius: 8,
  fontSize: 14,
  cursor: 'pointer',
}
const fileName = { fontSize: 14, color: '#475569' }
const clearFile = {
  marginLeft: 8,
  background: 'none',
  border: 'none',
  color: '#dc2626',
  cursor: 'pointer',
  fontSize: 18,
  padding: '0 4px',
}
const skillList = { listStyle: 'none' }
const skillItem = {
  display: 'flex',
  alignItems: 'center',
  gap: 12,
  padding: '10px 0',
  borderBottom: '1px solid #e2e8f0',
}
const category = { fontSize: 13, color: '#64748b' }
const removeBtn = {
  marginLeft: 'auto',
  background: 'none',
  border: 'none',
  color: '#dc2626',
  cursor: 'pointer',
  fontSize: 13,
}
