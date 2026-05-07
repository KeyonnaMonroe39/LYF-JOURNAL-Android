import { values } from '../data/content'
import { Hero } from '../components/Hero'
import { SectionHeader } from '../components/SectionHeader'
import { Card } from '../components/ui/card'
import { SEO } from '../components/SEO'

export function About() {
  return <><SEO title="About" /><Hero compact eyebrow="About LYF4Kids" title="Children deserve stories and tools that help them feel seen, emotionally equipped, and capable." primary={{ label: 'Contact / Partner', href: '/contact-partner' }}><p>LYF4Kids helps children feel seen, emotionally equipped, and capable through story, play, reflection, and adult-guided learning.</p></Hero><section className="py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader title="Our values" eyebrow="What guides the hub" /><div className="mt-10 grid gap-4 sm:grid-cols-2 lg:grid-cols-4">{values.map((value) => <Card key={value} className="text-center font-heading text-xl text-plum">{value}</Card>)}</div><div className="mt-10 rounded-4xl bg-white p-6 shadow-card"><p className="font-extrabold text-plum">Brand architecture note</p><p className="mt-2 leading-7 text-ink/75">Pretty2Me Foundation content and older girl-focused programming lives at pretty2me.de. LYF4Kids.org remains focused on coed children’s SEL media, curriculum, app experiences, and resources for ages 5–12.</p></div></div></section></>
}
