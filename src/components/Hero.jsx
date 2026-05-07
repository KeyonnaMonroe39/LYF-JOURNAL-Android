import { Link } from 'react-router-dom'
import { ArrowRight, Heart, Sparkles } from 'lucide-react'
import { motion, useReducedMotion } from 'framer-motion'
import { Button } from './ui/button'

export function Hero({ eyebrow, title, children, primary, secondary, compact = false }) {
  const reduce = useReducedMotion()
  return (
    <section className={`relative overflow-hidden bg-cream ${compact ? 'py-16 md:py-20' : 'py-20 md:py-28'}`}>
      <div className="absolute left-8 top-12 h-28 w-28 rounded-full bg-sky/25 blur-2xl" />
      <div className="absolute right-8 top-24 h-36 w-36 rounded-full bg-rose/25 blur-2xl" />
      <div className="absolute bottom-10 left-1/3 h-28 w-28 rounded-full bg-gold/30 blur-2xl" />
      <div className="mx-auto grid max-w-7xl items-center gap-10 px-4 sm:px-6 lg:grid-cols-[1.08fr_0.92fr] lg:px-8">
        <motion.div initial={reduce ? false : { opacity: 0, y: 20 }} animate={reduce ? undefined : { opacity: 1, y: 0 }} transition={{ duration: 0.55 }}>
          {eyebrow && <p className="mb-4 text-sm font-extrabold uppercase tracking-[0.24em] text-mauve">{eyebrow}</p>}
          <h1 className="font-heading text-4xl font-extrabold leading-[1.05] text-plum md:text-6xl">{title}</h1>
          <div className="mt-6 max-w-3xl text-xl leading-9 text-ink/75">{children}</div>
          {(primary || secondary) && (
            <div className="mt-8 flex flex-col gap-3 sm:flex-row">
              {primary && <Button asChild><Link to={primary.href}>{primary.label} <ArrowRight size={18} /></Link></Button>}
              {secondary && <Button asChild variant="secondary"><Link to={secondary.href}>{secondary.label}</Link></Button>}
            </div>
          )}
        </motion.div>
        <motion.div
          className="relative mx-auto min-h-80 w-full max-w-lg rounded-[2.5rem] border border-plum/10 bg-white/75 p-5 shadow-soft"
          initial={reduce ? false : { opacity: 0, scale: 0.96 }}
          animate={reduce ? undefined : { opacity: 1, scale: 1 }}
          transition={{ duration: 0.55, delay: 0.1 }}
          aria-hidden="true"
        >
          <div className="grid h-full min-h-72 grid-cols-2 gap-4">
            <div className="rounded-[2rem] bg-sky/25 p-5"><Sparkles className="text-plum" /><p className="mt-12 font-accent text-3xl text-plum">Wonder</p></div>
            <div className="rounded-[2rem] bg-peach/55 p-5"><Heart className="text-plum" /><p className="mt-12 font-accent text-3xl text-plum">Belong</p></div>
            <div className="rounded-[2rem] bg-gold/45 p-5"><p className="font-heading text-5xl text-plum">5–12</p><p className="mt-3 font-bold text-plum/75">story-based SEL</p></div>
            <div className="rounded-[2rem] bg-green/25 p-5"><p className="font-accent text-3xl text-plum">Brave hearts</p></div>
          </div>
        </motion.div>
      </div>
    </section>
  )
}
