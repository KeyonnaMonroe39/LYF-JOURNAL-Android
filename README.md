# LYF4Kids SEL Media + Curriculum Hub

This repository now includes a React/Vite website for **lyf4kids.org**, positioned as the official children’s SEL media and curriculum hub for LYF Matters Globally / LYF4Kids.

## Brand architecture

- `lyf4kids.org` is focused only on coed children’s SEL, story-based learning, curriculum, app experiences, and resources for boys and girls ages 5–12.
- The site features **The Hearte Family** and **The Wonderhood Adventures**.
- Pretty2Me Foundation content, older girl-focused programming, donor/sponsor messaging, and Pretty2Me-specific initiatives live at `pretty2me.de`.
- The website includes only a subtle footer/about cross-link to `pretty2me.de`.

## Content architecture

Primary pages:

1. Home
2. Meet the Hearte Family
3. Wonderhood Adventures
4. SEL Curriculum
5. For Schools & Educators
6. For Parents & Families
7. App Experience
8. Resources
9. About
10. Contact / Partner

Reusable content data lives in `src/data/content.js` and is shared by website pages and future app/PWA screens. It includes structured arrays/objects for audiences, age bands, SEL pillars, Wonderhood adventures, lessons, resources, app modules, Hearte Family characters, trust badges, values, and CTAs.

## Updating curriculum lessons and resources

Most content updates do not require touching page components:

- Add or edit curriculum pillars in `src/data/content.js` under `selPillars`.
- Add or edit age-band copy in `src/data/content.js` under `ageBands`.
- Add or edit lesson previews in `src/data/content.js` under `lessons`.
- Add or edit resource cards in `src/data/content.js` under `resources`.
- Add or edit Wonderhood adventures in `src/data/content.js` under `adventures`.
- Add future app/PWA modules in `src/data/content.js` under `appModules`.

When adding downloadable files later, place PDFs or assets in `public/` and add a URL field to the matching `resources` object. Then update `ResourceCard` to render direct download links or gated request flows.

## Placeholder items to replace before launch

- Connect `InquiryForm` to backend storage, CRM, email routing, or a form service.
- Connect `EmailSignupForm` to the preferred email marketing platform.
- Replace educator preview placeholder with the final PDF/download flow.
- Add standards alignment notes after curriculum review.
- Replace illustration-ready placeholder blocks with final Hearte Family and Wonderhood artwork.
- Add final legal/privacy/copyright pages and any required analytics/consent tooling.
- Decide whether resource downloads are public, gated, or account-based.

## Launch checklist for lyf4kids.org

- [ ] Confirm all brand copy keeps LYF4Kids focused on coed SEL for ages 5–12.
- [ ] Confirm Pretty2Me content is limited to subtle cross-links only.
- [ ] Connect contact, inquiry, signup, and resource request forms.
- [ ] Upload final resource PDFs and educator preview files.
- [ ] Add standards alignment and implementation documentation.
- [ ] Add final illustrations, character art, app/PWA screenshots, and favicon/OG images.
- [ ] Add privacy policy, terms, accessibility statement, and child-safety notes.
- [ ] Run production build and browser QA across mobile, tablet, and desktop.
- [ ] Verify keyboard navigation, visible focus states, color contrast, and reduced-motion behavior.
- [ ] Configure domain, hosting, redirects, sitemap, robots.txt, analytics, and backups.

## Development

```bash
npm install
npm run dev
npm run build
```

> Note: this environment blocked npm registry access during setup, so dependencies may need to be installed in a network-enabled development environment.
