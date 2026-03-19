import { api } from './client'

export const authApi = {
  login: (data) => api.post('/login', data),
  register: (data) => api.post('/register', data),
  logout: () => api.post('/logout'),
  isAuthenticated: () => api.get('/is-authenticated'),
  sendResetOtp: (email) => api.post(`/send-reset-otp?email=${encodeURIComponent(email)}`),
  resetPassword: (data) => api.post('/reset-password', data),
}
