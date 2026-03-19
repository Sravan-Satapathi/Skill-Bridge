import { useEffect, useState } from 'react'
import { SearchableRoleSelect } from '../components/SearchableRoleSelect'
import { careerApi, rolesApi } from '../api/career'

export function Gaps() {
  const [roles, setRoles] = useState([])
  const [selectedRoleId, setSelectedRoleId] = useState('')
  const [gaps, setGaps] = useState(null)
  const [loading, setLoading] = useState(false)

  useEffect(() => {
    rolesApi.getAll().then(setRoles)
  }, [])

  useEffect(() => {
    if (!selectedRoleId) {
      setGaps(null)
      return
    }
    setLoading(true)
    careerApi
      .getGaps(selectedRoleId)
      .then(setGaps)
      .catch(console.error)
      .finally(() => setLoading(false))
  }, [selectedRoleId])

  return (
    <div>
      <h1 style={h1}>Gap Analysis</h1>
      <p style={{ color: '#64748b', marginBottom: 24 }}>
        Compare your skills against a target role to see what you're missing.
      </p>

      <SearchableRoleSelect
        roles={roles}
        value={selectedRoleId}
        onChange={setSelectedRoleId}
        placeholder="Select a role"
        style={{ minWidth: 240 }}
      />

      {loading && <p style={{ marginTop: 16 }}>Loading...</p>}

      {gaps && !loading && (
        <div style={card}>
          <h2 style={h2}>{gaps.roleTitle}</h2>
          <p style={{ marginBottom: 16, color: '#475569' }}>
            Experience level: <strong>{gaps.experienceLevel}</strong>
          </p>
          <div style={scoreBox}>
            <span style={score}>{gaps.matchScore}%</span>
            <span style={scoreLabel}>match</span>
          </div>
          <p style={{ marginTop: 16, marginBottom: 24 }}>{gaps.summary}</p>

          {gaps.matchedCategories?.length > 0 && (
            <div style={section}>
              <h3 style={h3}>Matched categories</h3>
              <p style={tagList}>{gaps.matchedCategories.join(', ')}</p>
            </div>
          )}

          {gaps.missingCategoryGaps?.length > 0 && (
            <div style={section}>
              <h3 style={h3}>Missing categories</h3>
              <ul style={gapList}>
                {gaps.missingCategoryGaps.map((g) => (
                  <li key={g.category} style={gapItem}>
                    <strong>{g.category}</strong>
                    <p style={{ marginTop: 4, fontSize: 14, color: '#475569' }}>{g.message}</p>
                  </li>
                ))}
              </ul>
            </div>
          )}
        </div>
      )}
    </div>
  )
}

const h1 = { fontSize: 24, marginBottom: 8 }
const card = {
  marginTop: 24,
  background: '#fff',
  borderRadius: 12,
  padding: 24,
  boxShadow: '0 1px 3px rgba(0,0,0,0.06)',
}
const h2 = { fontSize: 20, marginBottom: 8 }
const scoreBox = {
  display: 'inline-flex',
  flexDirection: 'column',
  alignItems: 'center',
  background: '#f0f9ff',
  padding: '16px 24px',
  borderRadius: 8,
}
const score = { fontSize: 28, fontWeight: 700, color: '#0f172a' }
const scoreLabel = { fontSize: 12, color: '#64748b' }
const section = { marginTop: 24 }
const h3 = { fontSize: 14, fontWeight: 600, marginBottom: 8 }
const tagList = { fontSize: 14, color: '#475569' }
const gapList = { listStyle: 'none' }
const gapItem = {
  padding: '12px 0',
  borderBottom: '1px solid #e2e8f0',
}
