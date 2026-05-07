import { cn } from '../../lib/utils'

export function Card({ className, ...props }) {
  return <div className={cn('rounded-4xl border border-plum/10 bg-white/85 p-6 shadow-card', className)} {...props} />
}
