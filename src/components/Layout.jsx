import { useState } from 'react'
import { Link, NavLink, Outlet } from 'react-router-dom'
import { Menu, X } from 'lucide-react'
import { Button } from './ui/button'

const navItems = [
  { label: 'Hearte Family', href: '/hearte-family' },
  { label: 'Wonderhood', href: '/wonderhood-adventures' },
  { label: 'SEL Curriculum', href: '/sel-curriculum' },
  { label: 'Schools', href: '/schools-educators' },
  { label: 'Parents', href: '/parents-families' },
  { label: 'App', href: '/app-experience' },
  { label: 'Resources', href: '/resources' },
  { label: 'About', href: '/about' },
]

export function Layout() {
  const [open, setOpen] = useState(false)
  return (
    <div className="min-h-screen bg-cream font-body text-ink">
      <a href="#main" className="sr-only focus:not-sr-only focus:fixed focus:left-4 focus:top-4 focus:z-[100] focus:rounded-full focus:bg-gold focus:px-5 focus:py-3 focus:font-extrabold focus:text-plum">Skip to content</a>
      <header className="sticky top-0 z-50 border-b border-plum/10 bg-cream/92 backdrop-blur-xl">
        <nav className="mx-auto flex min-h-20 max-w-7xl items-center justify-between px-4 sm:px-6 lg:px-8" aria-label="Primary navigation">
          <Link to="/" className="flex items-center gap-3 rounded-full focus-visible:outline focus-visible:outline-4 focus-visible:outline-offset-4 focus-visible:outline-gold" onClick={() => setOpen(false)}>
            <span className="flex h-11 w-11 items-center justify-center rounded-2xl bg-plum font-heading text-lg font-extrabold text-gold">LYF</span>
            <span>
              <span className="block font-heading text-xl font-extrabold leading-5 text-plum">LYF4Kids</span>
              <span className="block text-xs font-extrabold uppercase tracking-[0.16em] text-mauve">SEL media hub</span>
            </span>
          </Link>
          <div className="hidden items-center gap-1 xl:flex">
            {navItems.map((item) => <NavItem key={item.href} item={item} />)}
          </div>
          <div className="hidden xl:block"><Button asChild><Link to="/contact-partner">Contact / Partner</Link></Button></div>
          <button type="button" className="inline-flex min-h-12 min-w-12 items-center justify-center rounded-full text-plum focus-visible:outline focus-visible:outline-4 focus-visible:outline-gold xl:hidden" onClick={() => setOpen((value) => !value)} aria-expanded={open} aria-controls="mobile-menu" aria-label="Toggle navigation">
            {open ? <X /> : <Menu />}
          </button>
        </nav>
        {open && (
          <div id="mobile-menu" className="border-t border-plum/10 bg-cream px-4 py-4 xl:hidden">
            <div className="grid gap-2">
              {navItems.map((item) => <NavItem key={item.href} item={item} onClick={() => setOpen(false)} />)}
              <Button asChild className="mt-2"><Link to="/contact-partner" onClick={() => setOpen(false)}>Contact / Partner</Link></Button>
            </div>
          </div>
        )}
      </header>
      <main id="main"><Outlet /></main>
      <Footer />
    </div>
  )
}

function NavItem({ item, onClick }) {
  return (
    <NavLink
      to={item.href}
      onClick={onClick}
      className={({ isActive }) => `rounded-full px-4 py-3 text-sm font-extrabold transition focus-visible:outline focus-visible:outline-4 focus-visible:outline-gold ${isActive ? 'bg-plum text-white' : 'text-plum hover:bg-plum/5'}`}
    >
      {item.label}
    </NavLink>
  )
}

function Footer() {
  return (
    <footer className="border-t border-plum/10 bg-white/70 py-12">
      <div className="mx-auto grid max-w-7xl gap-8 px-4 sm:px-6 lg:grid-cols-[1.1fr_1fr_1fr] lg:px-8">
        <div>
          <p className="font-heading text-2xl font-extrabold text-plum">LYF4Kids</p>
          <p className="mt-3 max-w-md leading-7 text-ink/70">The official children’s SEL media and curriculum hub for story-based learning, app experiences, and resources for boys and girls ages 5–12.</p>
          <p className="mt-4 text-sm text-ink/60">Pretty2Me Foundation content and older girl-focused programming lives at <a className="font-extrabold text-mauve underline-offset-4 hover:underline" href="https://pretty2me.de">pretty2me.de</a>.</p>
        </div>
        <div>
          <p className="font-extrabold text-plum">Explore</p>
          <div className="mt-3 grid gap-2">
            {navItems.slice(0, 6).map((item) => <Link key={item.href} className="font-bold text-ink/70 hover:text-plum" to={item.href}>{item.label}</Link>)}
          </div>
        </div>
        <div>
          <p className="font-extrabold text-plum">Partner pathways</p>
          <div className="mt-3 grid gap-2">
            <Link className="font-bold text-ink/70 hover:text-plum" to="/schools-educators">Schools & educators</Link>
            <Link className="font-bold text-ink/70 hover:text-plum" to="/parents-families">Parents & families</Link>
            <Link className="font-bold text-ink/70 hover:text-plum" to="/contact-partner">Sponsor, licensing, and workshops</Link>
          </div>
        </div>
      </div>
    </footer>
  )
}
