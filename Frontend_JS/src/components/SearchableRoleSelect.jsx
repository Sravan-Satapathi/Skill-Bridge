import { useEffect, useId, useRef, useState } from 'react'

export function SearchableRoleSelect({
  roles,
  value,
  onChange,
  placeholder = 'Select a role',
  style,
}) {
  const [open, setOpen] = useState(false)
  const [query, setQuery] = useState('')
  const [highlightIndex, setHighlightIndex] = useState(0)
  const containerRef = useRef(null)
  const listRef = useRef(null)
  const listboxId = useId()

  const selected = value ? roles.find((r) => r.id === value) : null
  const displayText = selected ? selected.title : ''

  const q = query.trim().toLowerCase()
  const filtered = !q
    ? roles
    : roles.filter(
        (r) =>
          r.title.toLowerCase().includes(q) ||
          r.id.toLowerCase().includes(q)
      )
  const displayList =
    selected && !filtered.some((r) => r.id === value) ? [selected, ...filtered] : filtered

  useEffect(() => {
    if (!open) return
    const handleClickOutside = (e) => {
      if (containerRef.current && !containerRef.current.contains(e.target)) {
        setOpen(false)
      }
    }
    document.addEventListener('mousedown', handleClickOutside)
    return () => document.removeEventListener('mousedown', handleClickOutside)
  }, [open])

  useEffect(() => {
    setHighlightIndex(0)
  }, [query, open])

  useEffect(() => {
    if (!open || !listRef.current) return
    const el = listRef.current.children[highlightIndex]
    el?.scrollIntoView({ block: 'nearest' })
  }, [highlightIndex, open, displayList.length])

  function handleKeyDown(e) {
    if (!open) {
      if (e.key === 'Enter' || e.key === ' ' || e.key === 'ArrowDown') {
        e.preventDefault()
        setOpen(true)
      }
      return
    }
    if (e.key === 'Escape') {
      setOpen(false)
      return
    }
    if (e.key === 'ArrowDown') {
      e.preventDefault()
      setHighlightIndex((i) => (displayList.length === 0 ? 0 : Math.min(i + 1, displayList.length - 1)))
      return
    }
    if (e.key === 'ArrowUp') {
      e.preventDefault()
      setHighlightIndex((i) => Math.max(i - 1, 0))
      return
    }
    if (e.key === 'Enter' && displayList.length > 0 && displayList[highlightIndex]) {
      e.preventDefault()
      onChange(displayList[highlightIndex].id)
      setOpen(false)
      setQuery('')
    }
  }

  return (
    <div ref={containerRef} style={{ position: 'relative', width: 'fit-content', maxWidth: '100%', ...style }}>
      <div
        role="combobox"
        aria-expanded={open}
        aria-haspopup="listbox"
        aria-controls={listboxId}
        tabIndex={0}
        onKeyDown={handleKeyDown}
        onClick={() => setOpen(!open)}
        style={trigger}
      >
        <span style={{ flex: 1, minWidth: 0, overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap', color: displayText ? undefined : '#94a3b8' }}>
          {displayText || placeholder}
        </span>
        <span style={{ ...chevron, flexShrink: 0 }}>{open ? '▲' : '▼'}</span>
      </div>

      {open && (
        <div style={dropdown}>
          <input
            type="text"
            placeholder="Search roles..."
            value={query}
            onChange={(e) => setQuery(e.target.value)}
            onKeyDown={(e) => {
              if (e.key === 'ArrowDown' || e.key === 'ArrowUp' || e.key === 'Enter') {
                e.preventDefault()
                handleKeyDown(e)
              }
            }}
            autoFocus
            style={searchInput}
          />
          <ul ref={listRef} id={listboxId} role="listbox" style={list}>
            {displayList.length === 0 ? (
              <li style={listItem}>No roles match</li>
            ) : (
              displayList.map((r, i) => (
                <li
                  key={r.id}
                  role="option"
                  aria-selected={r.id === value}
                  style={{
                    ...listItem,
                    ...(i === highlightIndex ? listItemHighlight : {}),
                  }}
                  onClick={() => {
                    onChange(r.id)
                    setOpen(false)
                    setQuery('')
                  }}
                  onMouseEnter={() => setHighlightIndex(i)}
                >
                  {r.title}
                </li>
              ))
            )}
          </ul>
        </div>
      )}
    </div>
  )
}

const trigger = {
  display: 'flex',
  alignItems: 'center',
  gap: 8,
  padding: '10px 12px',
  fontSize: 16,
  border: '1px solid #e2e8f0',
  borderRadius: 8,
  minWidth: 200,
  maxWidth: 320,
  background: '#fff',
  cursor: 'pointer',
  fontFamily: 'inherit',
}
const chevron = { fontSize: 10, color: '#64748b' }
const dropdown = {
  position: 'absolute',
  top: '100%',
  left: 0,
  right: 0,
  marginTop: 4,
  background: '#fff',
  border: '1px solid #e2e8f0',
  borderRadius: 8,
  boxShadow: '0 4px 12px rgba(0,0,0,0.1)',
  zIndex: 100,
  maxHeight: 280,
  overflow: 'hidden',
  display: 'flex',
  flexDirection: 'column',
}
const searchInput = {
  padding: '8px 12px',
  fontSize: 14,
  border: 'none',
  borderBottom: '1px solid #e2e8f0',
  outline: 'none',
  fontFamily: 'inherit',
}
const list = {
  listStyle: 'none',
  margin: 0,
  padding: '4px 0',
  maxHeight: 200,
  overflowY: 'auto',
}
const listItem = {
  padding: '10px 12px',
  fontSize: 14,
  cursor: 'pointer',
}
const listItemHighlight = {
  background: '#f1f5f9',
}
