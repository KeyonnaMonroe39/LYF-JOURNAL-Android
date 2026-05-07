import { InquiryForm, EmailSignupForm } from '../components/Forms'
import { Hero } from '../components/Hero'
import { SectionHeader } from '../components/SectionHeader'
import { PlaceholderNote } from '../components/Sections'
import { SEO } from '../components/SEO'

export function Contact() {
  return <><SEO title="Contact / Partner" /><Hero compact eyebrow="Contact / Partner" title="Start a school, curriculum, app, licensing, sponsor, or family resource conversation." primary={{ label: 'Complete inquiry below', href: '/contact-partner' }}><p>Tell us who you serve and what you want to explore. This front-end form is ready to connect to backend storage for inquiries, email signups, and resource requests.</p></Hero><section className="py-16"><div className="mx-auto grid max-w-7xl gap-8 px-4 sm:px-6 lg:grid-cols-[0.85fr_1.15fr] lg:px-8"><div><SectionHeader eyebrow="Inquiry form" title="How can LYF4Kids support your children, school, or organization?" /><div className="mt-8 grid gap-4"><PlaceholderNote>Backend placeholder: connect this form to your inquiries table, email routing, CRM, or form service.</PlaceholderNote><PlaceholderNote>Email signup and resource request placeholders can share the same content data for segmentation.</PlaceholderNote><EmailSignupForm /></div></div><InquiryForm /></div></section></>
}
