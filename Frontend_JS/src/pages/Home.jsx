import { Link } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'

export function Home() {
  const { isAuthenticated } = useAuth()

  return (
    <div style={styles.page}>
      <header style={styles.header}>
        <span style={styles.logo}>Skill-Bridge</span>
        <nav style={styles.nav}>
          {isAuthenticated ? (
            <Link to="/dashboard" style={styles.link}>
              Dashboard
            </Link>
          ) : (
            <>
              <Link to="/login" style={styles.link}>
                Login
              </Link>
              <Link to="/register" style={styles.btn}>
                Get Started
              </Link>
            </>
          )}
        </nav>
      </header>

      <main style={styles.main}>
        <h1 style={styles.h1}>Bridge the gap to your dream role</h1>
        <p style={styles.sub}>
          Upload your resume, get a personalized skill gap analysis, and a learning roadmap tailored to your target role.
        </p>
        {!isAuthenticated && (
          <Link to="/register" style={styles.cta}>
            Create free account
          </Link>
        )}
      </main>
    </div>
  )
}

const styles = {
  page: {
    minHeight: '100vh',
    background: 'linear-gradient(135deg, #f0f9ff 0%, #e0f2fe 100%)',
  },
  header: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    padding: '20px 32px',
    maxWidth: 960,
    margin: '0 auto',
  },
  logo: {
    fontSize: 22,
    fontWeight: 700,
    color: '#0f172a',
    textDecoration: 'none',
  },
  nav: {
    display: 'flex',
    gap: 16,
    alignItems: 'center',
  },
  link: {
    color: '#475569',
    textDecoration: 'none',
    fontSize: 15,
  },
  btn: {
    background: '#0f172a',
    color: '#fff',
    padding: '10px 20px',
    borderRadius: 8,
    textDecoration: 'none',
    fontSize: 15,
    fontWeight: 500,
  },
  main: {
    padding: 80,
    textAlign: 'center',
    maxWidth: 640,
    margin: '0 auto',
  },
  h1: {
    fontSize: 40,
    fontWeight: 700,
    color: '#0f172a',
    lineHeight: 1.2,
    marginBottom: 16,
  },
  sub: {
    fontSize: 18,
    color: '#64748b',
    lineHeight: 1.6,
    marginBottom: 32,
  },
  cta: {
    display: 'inline-block',
    background: '#0f172a',
    color: '#fff',
    padding: '14px 28px',
    borderRadius: 8,
    textDecoration: 'none',
    fontSize: 16,
    fontWeight: 600,
  },
}
