import { useEffect, useState } from 'react'
import { SearchableRoleSelect } from '../components/SearchableRoleSelect'
import { careerApi, rolesApi } from '../api/career'

export function Roadmap() {
  const [roles, setRoles] = useState([])
  const [selectedRoleId, setSelectedRoleId] = useState('')
  const [roadmap, setRoadmap] = useState(null)
  const [loading, setLoading] = useState(false)

  useEffect(() => {
    rolesApi.getAll().then(setRoles)
  }, [])

  useEffect(() => {
    if (!selectedRoleId) {
      setRoadmap(null)
      return
    }
    setLoading(true)
    careerApi
      .getRoadmap(selectedRoleId)
      .then(setRoadmap)
      .catch(console.error)
      .finally(() => setLoading(false))
  }, [selectedRoleId])

  const byCategory = roadmap?.missingSkills?.reduce(
    (acc, s) => {
      const cat = s.category || 'Other'
      if (!acc[cat]) acc[cat] = []
      acc[cat].push(s)
      return acc
    },
    {}
  ) ?? {}

  return (
    <div>
      <h1 style={h1}>Learning Roadmap</h1>
      <p style={{ color: '#64748b', marginBottom: 24 }}>
        Get a personalized learning path to fill your skill gaps.
      </p>

      <SearchableRoleSelect
        roles={roles}
        value={selectedRoleId}
        onChange={setSelectedRoleId}
        placeholder="Select a role"
        style={{ minWidth: 240 }}
      />

      {loading && <p style={{ marginTop: 16 }}>Loading...</p>}

      {roadmap && !loading && (
        <div style={card}>
          <h2 style={h2}>{roadmap.roleTitle}</h2>
          <p style={{ marginBottom: 24, color: '#475569' }}>
            Estimated time: <strong>{roadmap.estimatedTotalHours} hours</strong> (pick one per category)
          </p>

          {Object.entries(byCategory).map(([category, skills]) => (
            <div key={category} style={section}>
              <h3 style={h3}>{category}</h3>
              <ul style={skillList}>
                {skills.map((s, i) => (
                  <li key={`${s.skillName}-${i}`} style={skillItem}>
                    <div>
                      <strong>{s.skillName}</strong>
                      {s.suggestedResources?.length > 0 && (
                        <ul style={resourceList}>
                          {s.suggestedResources.map((r, j) => (
                            <li key={j} style={resourceItem}>
                              {r.name} {r.source && `(${r.source})`} — {r.estimatedHours}h
                            </li>
                          ))}
                        </ul>
                      )}
                    </div>
                  </li>
                ))}
              </ul>
            </div>
          ))}
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
const section = { marginTop: 24 }
const h3 = { fontSize: 14, fontWeight: 600, marginBottom: 12 }
const skillList = { listStyle: 'none' }
const skillItem = {
  padding: '12px 0',
  borderBottom: '1px solid #e2e8f0',
}
const resourceList = { marginTop: 8, paddingLeft: 20 }
const resourceItem = { fontSize: 13, color: '#64748b', marginBottom: 4 }
