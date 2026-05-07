import { Reveal } from './Motion'

export function SectionHeader({ eyebrow, title, children, align = 'left' }) {
  return (
    <Reveal className={align === 'center' ? 'mx-auto max-w-3xl text-center' : 'max-w-3xl'}>
      {eyebrow && <p className="mb-3 text-sm font-extrabold uppercase tracking-[0.24em] text-mauve">{eyebrow}</p>}
      <h2 className="font-heading text-3xl font-extrabold leading-tight text-plum md:text-5xl">{title}</h2>
      {children && <div className="mt-4 text-lg leading-8 text-ink/75">{children}</div>}
    </Reveal>
  )
}
