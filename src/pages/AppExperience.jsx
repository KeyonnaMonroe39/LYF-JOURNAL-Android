import { appModules, appSafety, journeySteps } from '../data/content'
import { Hero } from '../components/Hero'
import { AppModuleCard } from '../components/Cards'
import { SectionHeader } from '../components/SectionHeader'
import { JourneyMap, CTASection } from '../components/Sections'
import { SEO } from '../components/SEO'

export function AppExperience() {
  return <><SEO title="App Experience" /><Hero compact eyebrow="Future-ready PWA" title="A child-safe app experience that can grow from the same content system as the website." primary={{ label: 'Partner on the app', href: '/contact-partner' }} secondary={{ label: 'Explore resources', href: '/resources' }}><p>The LYF4Kids app/PWA structure uses reusable stories, lessons, resources, and grown-up guides for future interactive modules.</p></Hero><section className="py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader title="Core app modules" eyebrow="Modular content" /><div className="mt-10 grid gap-5 md:grid-cols-2 lg:grid-cols-3">{appModules.map((module) => <AppModuleCard key={module.title} module={module} />)}</div></div></section><section className="bg-white/55 py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader title="Child-safe by design" eyebrow="Safety model" /><div className="mt-10 grid gap-3 sm:grid-cols-2 lg:grid-cols-4">{appSafety.map((item) => <div key={item} className="rounded-3xl bg-cream px-5 py-4 font-extrabold text-plum shadow-sm">{item}</div>)}</div></div></section><section className="py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader title="Website-to-app learning journey" eyebrow="PWA architecture" /><div className="mt-10"><JourneyMap steps={journeySteps} /></div></div></section><CTASection title="Use the website as the app content foundation." primary={{ label: 'Discuss app modules', href: '/contact-partner' }} /></>
}
