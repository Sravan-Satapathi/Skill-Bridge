import { useState } from 'react'
import { Link } from 'react-router-dom'
import { AuthLayout } from '../components/AuthLayout'
import { FormField } from '../components/FormField'
import { authApi } from '../api/auth'

export function ForgotPassword() {
  const [email, setEmail] = useState('')
  const [sent, setSent] = useState(false)
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)

  async function handleSubmit(e) {
    e.preventDefault()
    setError('')
    setLoading(true)
    try {
      await authApi.sendResetOtp(email)
      setSent(true)
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Failed to send reset email')
    } finally {
      setLoading(false)
    }
  }

  if (sent) {
    return (
      <AuthLayout title="Check your email">
        <p style={{ color: '#475569', marginBottom: 24 }}>
          We've sent a reset code to <strong>{email}</strong>. Check your inbox, then enter the code and new password below.
        </p>
        <Link to={`/reset-password?email=${encodeURIComponent(email)}`} style={linkBtnStyle}>
          Enter reset code
        </Link>
        <p style={{ marginTop: 16 }}>
          <Link to="/login" style={linkStyle}>
            Back to sign in
          </Link>
        </p>
      </AuthLayout>
    )
  }

  return (
    <AuthLayout title="Reset password">
      <p style={{ color: '#64748b', marginBottom: 20, fontSize: 14 }}>
        Enter your email and we'll send you a one-time code to reset your password.
      </p>
      <form onSubmit={handleSubmit}>
        <FormField
          label="Email"
          type="email"
          value={email}
          onChange={setEmail}
          placeholder="you@example.com"
          required
        />
        {error && <p style={{ color: '#dc2626', marginBottom: 16, fontSize: 14 }}>{error}</p>}
        <button type="submit" disabled={loading} style={btnStyle}>
          {loading ? 'Sending...' : 'Send reset code'}
        </button>
      </form>
      <p style={{ marginTop: 20, fontSize: 14, color: '#64748b' }}>
        <Link to="/login">Back to sign in</Link>
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

const linkBtnStyle = {
  display: 'inline-block',
  padding: '12px 24px',
  background: '#0f172a',
  color: '#fff',
  borderRadius: 8,
  textDecoration: 'none',
  fontSize: 16,
  fontWeight: 600,
}

const linkStyle = {
  color: '#2563eb',
  fontSize: 14,
}
