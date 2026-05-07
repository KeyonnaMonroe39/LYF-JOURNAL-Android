import { Slot } from '@radix-ui/react-slot'
import { cva } from 'class-variance-authority'
import { cn } from '../../lib/utils'

const buttonVariants = cva(
  'inline-flex min-h-11 items-center justify-center rounded-full px-5 py-3 text-sm font-extrabold transition focus-visible:outline focus-visible:outline-4 focus-visible:outline-offset-2 focus-visible:outline-gold disabled:pointer-events-none disabled:opacity-50',
  {
    variants: {
      variant: {
        default: 'bg-plum text-white shadow-card hover:bg-mauve',
        secondary: 'border-2 border-plum/15 bg-white text-plum shadow-sm hover:border-plum/30 hover:bg-gold/20',
        gold: 'bg-gold text-plum shadow-card hover:bg-yellow',
        ghost: 'text-plum hover:bg-plum/5',
      },
    },
    defaultVariants: { variant: 'default' },
  },
)

export function Button({ className, variant, asChild = false, ...props }) {
  const Comp = asChild ? Slot : 'button'
  return <Comp className={cn(buttonVariants({ variant, className }))} {...props} />
}
