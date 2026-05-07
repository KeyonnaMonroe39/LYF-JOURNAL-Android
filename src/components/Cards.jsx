import { Link } from 'react-router-dom'
import { ArrowRight, Download, Sparkles } from 'lucide-react'
import { Card } from './ui/card'
import { Button } from './ui/button'
import { Reveal } from './Motion'

export function AudiencePathways({ audiences }) {
  return (
    <div className="grid gap-5 md:grid-cols-3">
      {audiences.map((audience, index) => {
        const Icon = audience.icon
        return (
          <Reveal key={audience.title} delay={index * 0.05}>
            <Link to={audience.href} className="group block h-full rounded-4xl focus-visible:outline focus-visible:outline-4 focus-visible:outline-offset-4 focus-visible:outline-gold">
              <Card className="h-full transition duration-300 group-hover:-translate-y-1 group-hover:shadow-soft">
                <div className={`mb-5 flex h-14 w-14 items-center justify-center rounded-2xl ${audience.color} text-plum`}>
                  <Icon aria-hidden="true" />
                </div>
                <h3 className="font-heading text-2xl font-bold text-plum">{audience.title}</h3>
                <p className="mt-3 leading-7 text-ink/75">{audience.description}</p>
                <span className="mt-5 inline-flex items-center gap-2 font-extrabold text-mauve">Explore path <ArrowRight size={18} /></span>
              </Card>
            </Link>
          </Reveal>
        )
      })}
    </div>
  )
}

export function SELPillarCard({ pillar }) {
  const Icon = pillar.icon
  return (
    <Card className="h-full">
      <div className={`mb-4 flex h-12 w-12 items-center justify-center rounded-2xl ${pillar.color} text-plum`}><Icon aria-hidden="true" /></div>
      <h3 className="font-heading text-xl font-bold text-plum">{pillar.title}</h3>
      <p className="mt-2 leading-7 text-ink/75">{pillar.description}</p>
    </Card>
  )
}

export function AdventureCard({ adventure }) {
  return (
    <Card className={`${adventure.color} flex h-full flex-col bg-opacity-100`}>
      <div className="mb-4 flex items-center justify-between gap-3 text-sm font-extrabold text-plum/75">
        <span>{adventure.age}</span>
        <span className="rounded-full bg-white/70 px-3 py-1">{adventure.skill}</span>
      </div>
      <h3 className="font-heading text-2xl font-bold text-plum">{adventure.title}</h3>
      <p className="mt-3 flex-1 leading-7 text-ink/75">{adventure.description}</p>
      <Button asChild variant="secondary" className="mt-5 self-start">
        <Link to="/app-experience">Start Adventure</Link>
      </Button>
    </Card>
  )
}

export function CharacterCard({ character }) {
  return (
    <Card className={`${character.color} h-full bg-opacity-100`}>
      <div className="mb-4 flex h-16 w-16 items-center justify-center rounded-full bg-white text-plum shadow-sm">
        <Sparkles aria-hidden="true" />
      </div>
      <p className="text-sm font-extrabold uppercase tracking-[0.18em] text-mauve">{character.role}</p>
      <h3 className="mt-2 font-heading text-2xl font-bold text-plum">{character.name}</h3>
      <p className="mt-3 leading-7 text-ink/75">{character.focus}</p>
    </Card>
  )
}

export function LessonPreviewCard({ lesson }) {
  const fields = [
    ['Objective', lesson.objective],
    ['Materials', lesson.materials],
    ['Activity', lesson.activity],
    ['Reflection', lesson.reflection],
    ['Home connection', lesson.homeConnection],
    ['Grown-up guide', lesson.grownUpGuide],
  ]
  return (
    <Card className="border-2 border-gold bg-white">
      <h3 className="font-heading text-2xl font-bold text-plum">{lesson.title}</h3>
      <div className="mt-6 grid gap-4 md:grid-cols-2">
        {fields.map(([label, value]) => (
          <div key={label} className="rounded-3xl bg-cream p-4">
            <p className="font-extrabold text-plum">{label}</p>
            <p className="mt-1 leading-7 text-ink/75">{value}</p>
          </div>
        ))}
      </div>
    </Card>
  )
}

export function ResourceCard({ resource }) {
  return (
    <Card className="flex h-full flex-col">
      <div className="mb-4 flex flex-wrap gap-2 text-xs font-extrabold uppercase tracking-[0.12em] text-plum/75">
        <span className="rounded-full bg-sky/20 px-3 py-1">{resource.audience}</span>
        <span className="rounded-full bg-green/20 px-3 py-1">{resource.age}</span>
        <span className="rounded-full bg-gold/40 px-3 py-1">{resource.type}</span>
      </div>
      <h3 className="font-heading text-2xl font-bold text-plum">{resource.title}</h3>
      <p className="mt-3 flex-1 leading-7 text-ink/75">{resource.description}</p>
      <Button variant="secondary" className="mt-5 self-start"><Download size={18} /> Request resource</Button>
    </Card>
  )
}

export function AppModuleCard({ module }) {
  const Icon = module.icon
  return (
    <Card className={`${module.color} h-full bg-opacity-100`}>
      <div className="mb-4 flex h-12 w-12 items-center justify-center rounded-2xl bg-white text-plum"><Icon aria-hidden="true" /></div>
      <h3 className="font-heading text-xl font-bold text-plum">{module.title}</h3>
      <p className="mt-2 leading-7 text-ink/75">{module.description}</p>
    </Card>
  )
}
