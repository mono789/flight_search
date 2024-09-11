import { Component, StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.tsx'
import Table from './components/Table.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
