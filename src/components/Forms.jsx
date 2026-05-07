import { useState } from 'react'
import { Button } from './ui/button'
import { Card } from './ui/card'

const inputClass = 'mt-2 min-h-12 w-full rounded-2xl border border-plum/15 bg-white px-4 py-3 text-ink outline-none transition focus:border-plum focus:ring-4 focus:ring-gold/35'

export function InquiryForm({ compact = false }) {
  const [submitted, setSubmitted] = useState(false)
  function handleSubmit(event) {
    event.preventDefault()
    setSubmitted(true)
  }
  return (
    <Card className="bg-white">
      <form onSubmit={handleSubmit} className="grid gap-5" name="lyf4kids-partnership-inquiry">
        <div className="grid gap-5 md:grid-cols-2">
          <Field label="Name" name="name" required />
          <Field label="Email" name="email" type="email" required />
          <Field label="Organization / School / Family" name="organization" />
          <Field label="Role" name="role" />
        </div>
        <label className="font-extrabold text-plum">
          Interested in
          <select name="interest" className={inputClass} defaultValue="Curriculum preview">
            {['School partnership', 'Curriculum preview', 'App', 'Licensing', 'Family resources', 'Speaking/workshop', 'Sponsor/partner', 'Other'].map((item) => <option key={item}>{item}</option>)}
          </select>
        </label>
        <label className="font-extrabold text-plum">
          Message
          <textarea name="message" rows={compact ? 4 : 6} className={inputClass} placeholder="Tell us what you are building, who you serve, and what you would like to preview." />
        </label>
        <p className="text-sm leading-6 text-ink/65">Placeholder form: connect this to your backend, CRM, or email marketing platform before launch.</p>
        <Button type="submit" className="justify-self-start">Send inquiry</Button>
        {submitted && <p role="status" className="rounded-2xl bg-green/20 p-4 font-bold text-plum">Thank you — this front-end placeholder captured the inquiry state. Backend storage still needs to be connected.</p>}
      </form>
    </Card>
  )
}

export function EmailSignupForm({ label = 'Join the parent and educator list' }) {
  const [submitted, setSubmitted] = useState(false)
  return (
    <form onSubmit={(event) => { event.preventDefault(); setSubmitted(true) }} className="flex flex-col gap-3 rounded-4xl bg-white/80 p-3 shadow-card sm:flex-row" name="lyf4kids-email-signup">
      <label className="sr-only" htmlFor="email-signup">Email address</label>
      <input id="email-signup" required type="email" placeholder="Email address" className="min-h-12 flex-1 rounded-full border border-plum/10 px-5 outline-none focus:border-plum focus:ring-4 focus:ring-gold/35" />
      <Button type="submit" variant="gold">{label}</Button>
      {submitted && <span className="sr-only" role="status">Signup submitted.</span>}
    </form>
  )
}

function Field({ label, name, type = 'text', required = false }) {
  return (
    <label className="font-extrabold text-plum">
      {label}
      <input name={name} type={type} required={required} className={inputClass} />
    </label>
  )
}
