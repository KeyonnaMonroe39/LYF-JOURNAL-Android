import { InquiryForm } from '../components/Forms'
import { Hero } from '../components/Hero'
import { SectionHeader } from '../components/SectionHeader'
import { PlaceholderNote } from '../components/Sections'
import { Card } from '../components/ui/card'
import { SEO } from '../components/SEO'

export function Schools() {
  const implementation = ['Classroom', 'Advisory', 'Small group', 'Afterschool', 'Camp', 'Counseling support']
  const included = ['Lesson plans', 'Story prompts', 'Worksheets', 'Activity cards', 'Parent connection tools', 'Facilitator notes']
  const outcomes = ['Emotional language', 'Classroom community', 'Conflict repair', 'Confidence', 'Empathy', 'Communication']
  return <><SEO title="For Schools & Educators" /><Hero compact eyebrow="For schools & educators" title="Warm, practical SEL tools for classrooms, camps, counseling groups, and youth programs." primary={{ label: 'Request educator preview', href: '/contact-partner' }}><p>Designed for educators, counselors, principals, SEL coordinators, afterschool leaders, camp directors, and youth organization buyers who need clear, age-appropriate tools.</p></Hero><Info title="Why LYF4Kids in schools" items={['Story-first lessons reduce stigma and invite participation.', 'Flexible activities fit classroom, small-group, and program settings.', 'Grown-up guides keep facilitation practical, warm, and clear.']} /><Grid title="Implementation settings" items={implementation} /><Grid title="What’s included" items={included} /><Grid title="Outcomes" items={outcomes} /><section className="py-16"><div className="mx-auto grid max-w-7xl gap-8 px-4 sm:px-6 lg:grid-cols-[0.9fr_1.1fr] lg:px-8"><div><SectionHeader eyebrow="Partnership inquiry" title="Tell us how your school or program wants to use LYF4Kids." /><div className="mt-8 grid gap-4"><PlaceholderNote>Download educator preview placeholder: replace with final PDF, gated download, or CRM-connected delivery.</PlaceholderNote><PlaceholderNote>Standards alignment placeholder: add CASEL/state/district alignment notes after review.</PlaceholderNote></div></div><InquiryForm compact /></div></section></>
}
function Info({ title, items }) { return <section className="py-16"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader title={title} eyebrow="Practical and credible" /><div className="mt-10 grid gap-5 md:grid-cols-3">{items.map((item) => <Card key={item}><p className="text-lg font-bold leading-8 text-plum">{item}</p></Card>)}</div></div></section> }
function Grid({ title, items }) { return <section className="bg-white/45 py-12"><div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"><SectionHeader title={title} /><div className="mt-8 grid gap-3 sm:grid-cols-2 lg:grid-cols-3">{items.map((item) => <div key={item} className="rounded-3xl bg-cream px-5 py-4 font-extrabold text-plum shadow-sm">{item}</div>)}</div></div></section> }
