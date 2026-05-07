import { EmailSignupForm } from '../components/Forms'
import { Hero } from '../components/Hero'
import { SectionHeader } from '../components/SectionHeader'
import { CTASection } from '../components/Sections'
import { Card } from '../components/ui/card'
import { SEO } from '../components/SEO'

export function Parents() {
  const sections = [
    ['Help your child talk about big feelings', 'Use story language, feelings charts, and validating scripts so children can say what is going on inside.'],
    ['Simple tools for everyday moments', 'Try one calming strategy, one repair sentence, or one confidence prompt during routines you already have.'],
    ['Family conversation starters', 'Short prompts support car rides, dinner tables, bedtime, sibling conflict, and after-school transitions.'],
    ['Home activities', 'Printable reflection cards, courage challenges, kindness practices, and simple Wonderhood imagination activities.'],
  ]
  return <><SEO title="For Parents & Families" /><Hero compact eyebrow="For parents & families" title="Help your child feel seen, safe, and able to try again." primary={{ label: 'Start at Home', href: '/resources' }} secondary={{ label: 'Get Family Resources', href: '/resources' }}><p>LYF4Kids gives caregivers warm, practical story tools for big feelings, friendship moments, confidence, kindness, and repair.</p></Hero><section className="py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader title="Family support that fits real life" eyebrow="At home" /><div className="mt-10 grid gap-5 md:grid-cols-2">{sections.map(([title, text]) => <Card key={title}><h3 className="font-heading text-2xl text-plum">{title}</h3><p className="mt-3 leading-7 text-ink/75">{text}</p></Card>)}</div><div className="mt-8 rounded-4xl bg-white p-6 shadow-card"><p className="font-extrabold text-plum">Emotional safety note</p><p className="mt-2 leading-7 text-ink/75">LYF4Kids is educational and supportive. It is not medical therapy, diagnosis, or crisis care. If a child needs clinical support, please consult a qualified professional or emergency resource.</p></div><div className="mt-8 max-w-3xl"><EmailSignupForm label="Get Family Resources" /></div></div></section><CTASection title="Start with one small conversation." primary={{ label: 'Browse resources', href: '/resources' }} secondary={{ label: 'Meet the Hearte Family', href: '/hearte-family' }} /></>
}
