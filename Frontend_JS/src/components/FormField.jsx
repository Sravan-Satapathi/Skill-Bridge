export function FormField({
  label,
  type = 'text',
  value,
  onChange,
  error,
  placeholder,
  required,
}) {
  return (
    <div style={{ marginBottom: 20 }}>
      <label style={labelStyle}>
        {label}
        {required && <span style={{ color: '#dc2626' }}> *</span>}
      </label>
      <input
        type={type}
        value={value}
        onChange={(e) => onChange(e.target.value)}
        placeholder={placeholder}
        required={required}
        style={{
          ...inputStyle,
          ...(error ? { borderColor: '#dc2626' } : {}),
        }}
      />
      {error && <p style={errorStyle}>{error}</p>}
    </div>
  )
}

const labelStyle = {
  display: 'block',
  fontSize: 14,
  fontWeight: 500,
  color: '#475569',
  marginBottom: 6,
}

const inputStyle = {
  width: '100%',
  padding: '10px 12px',
  fontSize: 16,
  border: '1px solid #e2e8f0',
  borderRadius: 8,
  outline: 'none',
}

const errorStyle = {
  fontSize: 13,
  color: '#dc2626',
  marginTop: 4,
}
