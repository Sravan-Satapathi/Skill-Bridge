const API_BASE = import.meta.env.VITE_BACKEND_URL
  ? `${import.meta.env.VITE_BACKEND_URL.replace(/\/$/, '')}/api`
  : '/api'

async function request(path, options = {}) {
  const res = await fetch(`${API_BASE}${path}`, {
    ...options,
    credentials: 'include',
    headers: {
      'Content-Type': 'application/json',
      ...options.headers,
    },
  })

  if (!res.ok) {
    const err = await res.json().catch(() => ({ message: res.statusText }))
    throw new Error(err.message || 'Request failed')
  }

  if (res.status === 204) return undefined
  const text = await res.text()
  if (!text.trim()) return undefined
  try {
    return JSON.parse(text)
  } catch {
    return undefined
  }
}

async function requestForm(path, formData, options = {}) {
  const res = await fetch(`${API_BASE}${path}`, {
    ...options,
    method: 'POST',
    credentials: 'include',
    body: formData,
    headers: options.headers,
  })

  if (!res.ok) {
    const err = await res.json().catch(() => ({ message: res.statusText }))
    throw new Error(err.message || 'Request failed')
  }

  const text = await res.text()
  if (!text.trim()) return undefined
  try {
    return JSON.parse(text)
  } catch {
    return undefined
  }
}

export const api = {
  get: (path) => request(path, { method: 'GET' }),
  post: (path, body) =>
    request(path, { method: 'POST', body: body ? JSON.stringify(body) : undefined }),
  postForm: (path, file, mergeStrategy = 'REPLACE') => {
    const formData = new FormData()
    formData.append('file', file)
    formData.append('mergeStrategy', mergeStrategy)
    return requestForm(path, formData)
  },
  put: (path, body) =>
    request(path, { method: 'PUT', body: body ? JSON.stringify(body) : undefined }),
  delete: (path) => request(path, { method: 'DELETE' }),
}
