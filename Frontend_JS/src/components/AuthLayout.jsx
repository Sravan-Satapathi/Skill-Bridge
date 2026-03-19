import { Link } from 'react-router-dom'

export function AuthLayout({ children, title }) {
  return (
    <div style={styles.page}>
      <div style={styles.card}>
        <Link to="/" style={styles.logo}>
          Skill-Bridge
        </Link>
        <h1 style={styles.title}>{title}</h1>
        {children}
      </div>
    </div>
  )
}

const styles = {
  page: {
    minHeight: '100vh',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    padding: 24,
    background: 'linear-gradient(135deg, #f0f9ff 0%, #e0f2fe 100%)',
  },
  card: {
    width: '100%',
    maxWidth: 400,
    background: '#fff',
    borderRadius: 12,
    boxShadow: '0 4px 24px rgba(0,0,0,0.08)',
    padding: 32,
  },
  logo: {
    display: 'block',
    fontSize: 20,
    fontWeight: 700,
    color: '#0f172a',
    marginBottom: 24,
    textDecoration: 'none',
  },
  title: {
    fontSize: 24,
    fontWeight: 600,
    color: '#1e293b',
    marginBottom: 24,
  },
}
