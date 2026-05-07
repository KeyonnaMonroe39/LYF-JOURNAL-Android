import {
  BookOpen,
  Brain,
  HandHeart,
  HeartHandshake,
  Home,
  Map,
  MessageCircleHeart,
  Palette,
  School,
  ShieldCheck,
  Sparkles,
  Sprout,
  Star,
  Users,
  Waves,
} from 'lucide-react'

export const audiences = [
  {
    title: 'Families',
    description: 'Warm story tools, printable prompts, and guided routines for everyday big-feeling moments at home.',
    href: '/parents-families',
    icon: Home,
    color: 'bg-peach',
  },
  {
    title: 'Educators',
    description: 'Classroom-ready SEL story lessons, worksheets, facilitator notes, and parent connection tools.',
    href: '/schools-educators',
    icon: School,
    color: 'bg-sky',
  },
  {
    title: 'Camps & Community Programs',
    description: 'Flexible adventure-based activities for camps, libraries, afterschool, counseling groups, and youth spaces.',
    href: '/contact-partner',
    icon: Users,
    color: 'bg-green',
  },
]

export const themes = ['Feelings', 'Friendship', 'Confidence', 'Kindness', 'Courage', 'Repair', 'Belonging', 'Wonder']

export const trustBadges = [
  'Age-appropriate',
  'Classroom-ready',
  'Parent-friendly',
  'Healing-centered',
  'Culturally respectful',
]

export const ageBands = [
  {
    title: 'Ages 5–7',
    focus: 'Naming feelings, calming strategies, kindness, and asking for help.',
    color: 'border-sky bg-sky/15',
  },
  {
    title: 'Ages 8–10',
    focus: 'Friendship, conflict, problem-solving, confidence, and supportive self-talk.',
    color: 'border-green bg-green/15',
  },
  {
    title: 'Ages 11–12',
    focus: 'Identity, leadership, communication, boundaries, repair, and belonging.',
    color: 'border-lavender bg-lavender/20',
  },
]

export const selPillars = [
  {
    title: 'Name It',
    description: 'Emotional vocabulary and self-awareness that help children say what is happening inside.',
    icon: MessageCircleHeart,
    color: 'bg-sky',
  },
  {
    title: 'Feel It Safely',
    description: 'Regulation, breath, body cues, and calm-down tools for safe expression.',
    icon: Waves,
    color: 'bg-lavender',
  },
  {
    title: 'Share It',
    description: 'Communication, listening, perspective-taking, and empathy with peers and grown-ups.',
    icon: HeartHandshake,
    color: 'bg-peach',
  },
  {
    title: 'Repair It',
    description: 'Accountability, forgiveness, conflict repair, and practical problem-solving language.',
    icon: HandHeart,
    color: 'bg-coral',
  },
  {
    title: 'Grow With It',
    description: 'Confidence, resilience, leadership, belonging, and brave next steps.',
    icon: Sprout,
    color: 'bg-green',
  },
]

export const characters = [
  { name: 'Hope Hearte', role: 'Mother', focus: 'Naming feelings with warmth, repair after hard moments, and family connection.', color: 'bg-rose/20' },
  { name: 'Jake Hearte', role: 'Father', focus: 'Problem-solving, listening, confidence, and calm support during everyday challenges.', color: 'bg-gold/35' },
  { name: 'Nick Hearte', role: 'Child', focus: 'Courage, friendship choices, asking for help, and trying again.', color: 'bg-sky/20' },
  { name: 'Paige Hearte', role: 'Child', focus: 'Kindness, self-expression, emotional words, and sibling repair.', color: 'bg-lavender/25' },
  { name: 'Grandma Hearte', role: 'Grandmother', focus: 'Wisdom, belonging, family stories, patience, and steady encouragement.', color: 'bg-peach/35' },
  { name: 'Grandpa Hearte', role: 'Grandfather', focus: 'Resilience, practical tools, humor, and trying a new strategy.', color: 'bg-green/20' },
  { name: 'Mr. Barkley', role: 'Family dog', focus: 'Playful body cues, comfort, routine, and noticing what helps us feel safe.', color: 'bg-yellow/25' },
]

export const adventures = [
  { title: 'The Feelings Forest', age: 'Ages 7–12', skill: 'Emotional language', description: 'Children follow clues through color-coded feelings and practice naming what they notice inside.', color: 'bg-sky/20' },
  { title: 'Courage Canyon', age: 'Ages 7–12', skill: 'Bravery and resilience', description: 'A winding canyon invites children to take brave, safe steps and ask for help when the path gets steep.', color: 'bg-coral/20' },
  { title: 'Friendship Bridge', age: 'Ages 7–12', skill: 'Friendship and communication', description: 'Teams rebuild a bridge by listening, taking turns, and practicing words that keep connection strong.', color: 'bg-green/20' },
  { title: 'Kindness Kitchen', age: 'Ages 7–12', skill: 'Empathy and generosity', description: 'Recipes become reflection prompts as children notice needs, offer help, and celebrate different traditions.', color: 'bg-peach/35' },
  { title: 'Repair River', age: 'Ages 7–12', skill: 'Accountability and repair', description: 'Children cross stepping stones of apology, responsibility, forgiveness, and next-right-choice planning.', color: 'bg-teal/15' },
  { title: 'Confidence Mountain', age: 'Ages 7–12', skill: 'Confidence and self-talk', description: 'A climb with pauses for supportive self-talk, strengths spotting, and celebrating effort.', color: 'bg-yellow/25' },
  { title: 'Wonder Workshop', age: 'Ages 7–12', skill: 'STEAM and curiosity', description: 'Children prototype creative solutions while practicing teamwork, flexible thinking, and curiosity.', color: 'bg-lavender/25' },
  { title: 'Belonging Bay', age: 'Ages 7–12', skill: 'Belonging and cultural respect', description: 'An imaginative shoreline helps groups honor stories, names, traditions, and inclusive community rituals.', color: 'bg-rose/20' },
]

export const lessonFormats = [
  'Story lessons',
  'Printable worksheets',
  'Classroom activities',
  'Family conversation cards',
  'Reflection prompts',
  'Songs/audio moments',
  'App-based interactive activities',
  'Teacher guides',
  'Parent guides',
]

export const lessons = [
  {
    title: 'Sample Lesson: When Feelings Get Loud',
    objective: 'Children will name a big feeling, notice one body cue, and choose one safe calming strategy.',
    materials: 'Feelings chart, crayons, calm-down card, story prompt, reflection sheet.',
    activity: 'Read a short Hearte Family scenario, invite children to color the feeling, then practice a breath-and-choice routine.',
    reflection: 'What did the feeling want you to know? What helped your body feel safer?',
    homeConnection: 'Send home a two-question conversation card for grown-ups to use after school or before bedtime.',
    grownUpGuide: 'Validate the feeling first, then guide the child toward a safe next step without shaming the emotion.',
  },
]

export const resources = [
  { title: 'Feelings Chart', audience: 'Families + Educators', age: 'Ages 5–12', type: 'Printable', description: 'A child-friendly visual chart for naming feelings and choosing a next helpful step.' },
  { title: 'Conversation Cards', audience: 'Families', age: 'Ages 5–12', type: 'Card deck', description: 'Simple prompts for car rides, bedtime, dinner tables, and big-feeling moments.' },
  { title: 'Calm-Down Cards', audience: 'Children + Grown-ups', age: 'Ages 5–12', type: 'Printable', description: 'Breathing, grounding, movement, and sensory choices children can practice safely.' },
  { title: 'Friendship Repair Worksheet', audience: 'Educators + Families', age: 'Ages 7–12', type: 'Worksheet', description: 'A guided repair flow for accountability, listening, apology, and next steps.' },
  { title: 'Courage Challenge Sheet', audience: 'Children', age: 'Ages 7–12', type: 'Activity', description: 'A strengths-based challenge sheet for practicing brave choices in small steps.' },
  { title: 'Educator Preview', audience: 'Schools + Programs', age: 'Ages 5–12', type: 'Preview PDF', description: 'Placeholder curriculum sample with lesson flow, implementation ideas, and standards notes.' },
  { title: 'Parent Starter Guide', audience: 'Families', age: 'Ages 5–12', type: 'Guide', description: 'A warm quick-start guide for using LYF4Kids stories and tools at home.' },
]

export const appModules = [
  { title: 'Feelings Check-In', description: 'A visual emotional vocabulary moment that helps children name feelings and choose support.', icon: Brain, color: 'bg-sky/20' },
  { title: 'Wonderhood Map', description: 'A playful map of adventure worlds, lesson paths, and child-safe exploration.', icon: Map, color: 'bg-lavender/25' },
  { title: 'Story Lessons', description: 'Hearte Family and Wonderhood story prompts with reflection and grown-up guidance.', icon: BookOpen, color: 'bg-peach/35' },
  { title: 'Calm Corner', description: 'Breath, body cue, grounding, and calming strategy activities for safe regulation.', icon: Waves, color: 'bg-teal/15' },
  { title: 'Friendship Lab', description: 'Scenario practice for listening, boundaries, repair, kindness, and teamwork.', icon: HeartHandshake, color: 'bg-green/20' },
  { title: 'Confidence Builder', description: 'Strength spotting, supportive self-talk, courage challenges, and reflection badges.', icon: Star, color: 'bg-yellow/25' },
  { title: 'Grown-Up Guide', description: 'Parent and educator scripts, prompts, and context for guided use.', icon: ShieldCheck, color: 'bg-rose/20' },
]

export const ctas = {
  wonderhood: { label: 'Explore Wonderhood', href: '/wonderhood-adventures' },
  curriculum: { label: 'View the SEL Curriculum', href: '/sel-curriculum' },
  educatorPreview: { label: 'Request the Educator Preview', href: '/contact-partner' },
  parentList: { label: 'Join the Parent List', href: '/parents-families' },
  hearteTools: { label: 'Explore The Hearte Family SEL Tools', href: '/resources' },
}

export const values = ['Emotional safety', 'Belonging', 'Courage', 'Kindness', 'Creativity', 'Repair', 'Cultural respect', 'Practical tools']

export const appSafety = [
  'Child-safe',
  'No social feed',
  'No public profiles',
  'No unmoderated sharing',
  'Grown-up guided where needed',
  'Sample content accessible without login',
  'Optional grown-up sign-in later',
]

export const journeySteps = [
  { title: 'Story', description: 'Children meet a relatable moment through The Hearte Family or Wonderhood.' },
  { title: 'Name', description: 'They identify feelings, body cues, choices, and support needs.' },
  { title: 'Practice', description: 'A worksheet, activity, or app module turns insight into a concrete skill.' },
  { title: 'Connect', description: 'Grown-up prompts carry the learning into home, classroom, or program life.' },
]

export const decorativeIcons = { Sparkles, Palette }
