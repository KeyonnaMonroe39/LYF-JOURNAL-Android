import { Link } from 'react-router-dom'
import { CheckCircle2 } from 'lucide-react'
import { Button } from './ui/button'
import { Card } from './ui/card'
import { Reveal } from './Motion'

export function CTASection({ eyebrow = 'Next step', title, children, primary, secondary }) {
  return (
    <section className="bg-plum py-16 text-white">
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div className="grid items-center gap-8 lg:grid-cols-[1fr_auto]">
          <div>
            <p className="mb-3 text-sm font-extrabold uppercase tracking-[0.24em] text-gold">{eyebrow}</p>
            <h2 className="font-heading text-3xl font-extrabold md:text-5xl">{title}</h2>
            {children && <p className="mt-4 max-w-3xl text-lg leading-8 text-white/78">{children}</p>}
          </div>
          <div className="flex flex-col gap-3 sm:flex-row lg:flex-col">
            {primary && <Button asChild variant="gold"><Link to={primary.href}>{primary.label}</Link></Button>}
            {secondary && <Button asChild variant="secondary"><Link to={secondary.href}>{secondary.label}</Link></Button>}
          </div>
        </div>
      </div>
    </section>
  )
}

export function TrustBadges({ items }) {
  return (
    <div className="grid gap-3 sm:grid-cols-2 lg:grid-cols-5">
      {items.map((item) => (
        <Reveal key={item}>
          <div className="flex min-h-20 items-center gap-3 rounded-3xl bg-white p-4 font-extrabold text-plum shadow-card">
            <CheckCircle2 className="shrink-0 text-teal" aria-hidden="true" />
            {item}
          </div>
        </Reveal>
      ))}
    </div>
  )
}

export function JourneyMap({ steps }) {
  return (
    <div className="grid gap-5 md:grid-cols-4">
      {steps.map((step, index) => (
        <Card key={step.title} className="relative h-full">
          <div className="mb-4 flex h-10 w-10 items-center justify-center rounded-full bg-plum font-heading text-white">{index + 1}</div>
          <h3 className="font-heading text-xl font-bold text-plum">{step.title}</h3>
          <p className="mt-2 leading-7 text-ink/75">{step.description}</p>
        </Card>
      ))}
    </div>
  )
}

export function PlaceholderNote({ children }) {
  return <div className="rounded-4xl border border-dashed border-mauve/40 bg-white/70 p-6 text-ink/75">{children}</div>
}
