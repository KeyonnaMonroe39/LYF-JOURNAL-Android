import { Link } from 'react-router-dom'
import { audiences, ctas, selPillars, themes, trustBadges } from '../data/content'
import { Hero } from '../components/Hero'
import { AudiencePathways, SELPillarCard } from '../components/Cards'
import { SectionHeader } from '../components/SectionHeader'
import { TrustBadges, CTASection } from '../components/Sections'
import { SEO } from '../components/SEO'
import { Button } from '../components/ui/button'

export function Home() {
  return (
    <>
      <SEO title="Children’s SEL Stories, Curriculum, and App Experiences" />
      <Hero title="Big feelings. Brave hearts. Wonder-filled learning." primary={ctas.wonderhood} secondary={ctas.curriculum}>
        LYF4Kids helps children ages 5–12 build emotional language, confidence, friendship skills, empathy, and problem-solving through The Hearte Family and The Wonderhood Adventures.
      </Hero>
      <section className="py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader eyebrow="Choose your path" title="Built for the grown-ups who guide children — and the children learning to guide themselves." /><div className="mt-10"><AudiencePathways audiences={audiences} /></div></div></section>
      <section className="bg-white/55 py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader align="center" eyebrow="SEL themes" title="A colorful language for everyday growth." /><div className="mt-10 flex flex-wrap justify-center gap-3">{themes.map((theme) => <span key={theme} className="rounded-full bg-cream px-5 py-3 font-extrabold text-plum shadow-sm">{theme}</span>)}</div><div className="mt-12 grid gap-5 md:grid-cols-2 lg:grid-cols-5">{selPillars.map((pillar) => <SELPillarCard key={pillar.title} pillar={pillar} />)}</div></div></section>
      <section className="py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><div className="grid gap-8 lg:grid-cols-[0.9fr_1.1fr]"><SectionHeader eyebrow="Brand clarity" title="LYF4Kids.org is the children’s SEL hub."><p>The site is intentionally focused on coed, story-based learning for boys and girls ages 5–12. Pretty2Me Foundation initiatives, older tween/teen girl empowerment content, and donor-specific foundation messaging live separately at pretty2me.de.</p><div className="mt-6"><Button asChild variant="secondary"><Link to="/about">Learn about LYF4Kids</Link></Button></div></SectionHeader><TrustBadges items={trustBadges} /></div></div></section>
      <CTASection title="Ready to preview the curriculum or explore a partnership?" primary={{ label: 'Contact / Partner', href: '/contact-partner' }} secondary={ctas.curriculum}>Start with a story world, a classroom-ready lesson, or a family resource path.</CTASection>
    </>
  )
}
