import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { AuthLayout } from '../components/AuthLayout'
import { FormField } from '../components/FormField'
import { authApi } from '../api/auth'
import { useAuth } from '../context/AuthContext'

export function Register() {
  const [name, setName] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)
  const navigate = useNavigate()
  const { checkAuth } = useAuth()

  async function handleSubmit(e) {
    e.preventDefault()
    setError('')
    if (password.length < 6) {
      setError('Password must be at least 6 characters')
      return
    }
    setLoading(true)
    try {
      await authApi.register({ name, email, password })
      await authApi.login({ email, password })
      await checkAuth()
      navigate('/dashboard')
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Registration failed')
    } finally {
      setLoading(false)
    }
  }

  return (
    <AuthLayout title="Create account">
      <form onSubmit={handleSubmit}>
        <FormField
          label="Name"
          value={name}
          onChange={setName}
          placeholder="Your name"
          required
        />
        <FormField
          label="Email"
          type="email"
          value={email}
          onChange={setEmail}
          placeholder="you@example.com"
          required
        />
        <FormField
          label="Password"
          type="password"
          value={password}
          onChange={setPassword}
          placeholder="Min 6 characters"
          required
        />
        {error && <p style={{ color: '#dc2626', marginBottom: 16, fontSize: 14 }}>{error}</p>}
        <button type="submit" disabled={loading} style={btnStyle}>
          {loading ? 'Creating account...' : 'Create account'}
        </button>
      </form>
      <p style={{ marginTop: 20, fontSize: 14, color: '#64748b' }}>
        Already have an account? <Link to="/login">Sign in</Link>
      </p>
    </AuthLayout>
  )
}

const btnStyle = {
  width: '100%',
  padding: 12,
  fontSize: 16,
  fontWeight: 600,
  background: '#0f172a',
  color: '#fff',
  border: 'none',
  borderRadius: 8,
  cursor: 'pointer',
}
