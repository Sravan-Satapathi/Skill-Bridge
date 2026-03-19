import { useState } from 'react'
import { Link, useSearchParams } from 'react-router-dom'
import { AuthLayout } from '../components/AuthLayout'
import { FormField } from '../components/FormField'
import { authApi } from '../api/auth'

export function ResetPassword() {
  const [searchParams] = useSearchParams()
  const emailParam = searchParams.get('email') || ''
  const [email, setEmail] = useState(emailParam)
  const [otp, setOtp] = useState('')
  const [newPassword, setNewPassword] = useState('')
  const [error, setError] = useState('')
  const [success, setSuccess] = useState(false)
  const [loading, setLoading] = useState(false)

  async function handleSubmit(e) {
    e.preventDefault()
    setError('')
    if (newPassword.length < 6) {
      setError('Password must be at least 6 characters')
      return
    }
    setLoading(true)
    try {
      await authApi.resetPassword({ email, otp, newPassword })
      setSuccess(true)
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Reset failed')
    } finally {
      setLoading(false)
    }
  }

  if (success) {
    return (
      <AuthLayout title="Password reset">
        <p style={{ color: '#475569', marginBottom: 24 }}>
          Your password has been reset. You can now sign in with your new password.
        </p>
        <Link to="/login" style={btnStyle}>
          Sign in
        </Link>
      </AuthLayout>
    )
  }

  return (
    <AuthLayout title="Set new password">
      <form onSubmit={handleSubmit}>
        <FormField
          label="Email"
          type="email"
          value={email}
          onChange={setEmail}
          placeholder="you@example.com"
          required
        />
        <FormField
          label="OTP (from email)"
          value={otp}
          onChange={setOtp}
          placeholder="Enter 6-digit code"
          required
        />
        <FormField
          label="New password"
          type="password"
          value={newPassword}
          onChange={setNewPassword}
          placeholder="Min 6 characters"
          required
        />
        {error && <p style={{ color: '#dc2626', marginBottom: 16, fontSize: 14 }}>{error}</p>}
        <button type="submit" disabled={loading} style={btnStyle}>
          {loading ? 'Resetting...' : 'Reset password'}
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
  textAlign: 'center',
  textDecoration: 'none',
  display: 'block',
}
