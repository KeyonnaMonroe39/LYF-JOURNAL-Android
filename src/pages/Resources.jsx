import { resources } from '../data/content'
import { Hero } from '../components/Hero'
import { ResourceCard } from '../components/Cards'
import { SectionHeader } from '../components/SectionHeader'
import { SEO } from '../components/SEO'

export function Resources() {
  return <><SEO title="Resources" /><Hero compact eyebrow="Downloadable resources" title="Printable and preview-ready tools for feelings, friendship, courage, and repair." primary={{ label: 'Request resource access', href: '/contact-partner' }}><p>Resource cards are structured for future downloadable PDFs, email capture, school previews, and app/PWA activities.</p></Hero><section className="py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader title="Resource library" eyebrow="Cards to connect later" /><div className="mt-10 grid gap-5 md:grid-cols-2 lg:grid-cols-3">{resources.map((resource) => <ResourceCard key={resource.title} resource={resource} />)}</div></div></section></>
}
