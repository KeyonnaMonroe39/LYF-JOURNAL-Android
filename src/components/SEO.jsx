import { useEffect } from 'react'

const defaultDescription = 'LYF4Kids helps children ages 5–12 build emotional language, confidence, friendship skills, empathy, and problem-solving through story-based SEL learning.'

export function SEO({ title, description = defaultDescription }) {
  useEffect(() => {
    document.title = title ? `${title} | LYF4Kids` : 'LYF4Kids | Children’s SEL Stories, Curriculum, and App Experiences'
    setMeta('description', description)
    setMeta('og:title', document.title, 'property')
    setMeta('og:description', description, 'property')
  }, [title, description])
  return null
}

function setMeta(name, content, attr = 'name') {
  let tag = document.head.querySelector(`meta[${attr}="${name}"]`)
  if (!tag) {
    tag = document.createElement('meta')
    tag.setAttribute(attr, name)
    document.head.appendChild(tag)
  }
  tag.setAttribute('content', content)
}
