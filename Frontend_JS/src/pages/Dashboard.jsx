import { Link, NavLink, Outlet, useNavigate } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'

export function Dashboard() {
  const { logout } = useAuth()
  const navigate = useNavigate()

  return (
    <div style={styles.page}>
      <header style={styles.header}>
        <Link to="/dashboard" style={styles.logo}>
          Skill-Bridge
        </Link>
        <nav style={styles.nav}>
          <NavLink
            to="/dashboard"
            end
            style={({ isActive }) => ({ ...styles.link, ...(isActive ? styles.linkActive : {}) })}
          >
            Profile
          </NavLink>
          <NavLink
            to="/dashboard/gaps"
            style={({ isActive }) => ({ ...styles.link, ...(isActive ? styles.linkActive : {}) })}
          >
            Gap Analysis
          </NavLink>
          <NavLink
            to="/dashboard/roadmap"
            style={({ isActive }) => ({ ...styles.link, ...(isActive ? styles.linkActive : {}) })}
          >
            Roadmap
          </NavLink>
          <button
            onClick={async () => {
              await logout()
              navigate('/')
            }}
            style={styles.logout}
          >
            Logout
          </button>
        </nav>
      </header>
      <main style={styles.main}>
        <Outlet />
      </main>
    </div>
  )
}

const styles = {
  page: {
    minHeight: '100vh',
    background: '#f1f5f9',
  },
  header: {
    background: '#fff',
    borderBottom: '1px solid #e2e8f0',
    padding: '16px 24px',
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  logo: {
    fontSize: 20,
    fontWeight: 700,
    color: '#0f172a',
    textDecoration: 'none',
  },
  nav: {
    display: 'flex',
    gap: 24,
    alignItems: 'center',
  },
  link: {
    color: '#475569',
    textDecoration: 'none',
    fontSize: 15,
  },
  linkActive: {
    fontWeight: 600,
    color: '#0f172a',
  },
  logout: {
    background: 'none',
    border: 'none',
    color: '#64748b',
    cursor: 'pointer',
    fontSize: 14,
  },
  main: {
    maxWidth: 900,
    margin: '0 auto',
    padding: 32,
  },
}
