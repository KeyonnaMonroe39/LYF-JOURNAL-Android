import React from 'react'
import ReactDOM from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import { Layout } from './components/Layout'
import { Home } from './pages/Home'
import { HearteFamily } from './pages/HearteFamily'
import { Wonderhood } from './pages/Wonderhood'
import { Curriculum } from './pages/Curriculum'
import { Schools } from './pages/Schools'
import { Parents } from './pages/Parents'
import { AppExperience } from './pages/AppExperience'
import { Resources } from './pages/Resources'
import { About } from './pages/About'
import { Contact } from './pages/Contact'
import './styles.css'

const router = createBrowserRouter([
  {
    path: '/',
    element: <Layout />,
    children: [
      { index: true, element: <Home /> },
      { path: 'hearte-family', element: <HearteFamily /> },
      { path: 'wonderhood-adventures', element: <Wonderhood /> },
      { path: 'sel-curriculum', element: <Curriculum /> },
      { path: 'schools-educators', element: <Schools /> },
      { path: 'parents-families', element: <Parents /> },
      { path: 'app-experience', element: <AppExperience /> },
      { path: 'resources', element: <Resources /> },
      { path: 'about', element: <About /> },
      { path: 'contact-partner', element: <Contact /> },
    ],
  },
])

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
