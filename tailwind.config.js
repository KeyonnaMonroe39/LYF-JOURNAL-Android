/** @type {import('tailwindcss').Config} */
export default {
  content: ['./index.html', './src/**/*.{js,jsx}'],
  theme: {
    extend: {
      colors: {
        plum: '#3E2437',
        mauve: '#8E5A6F',
        rose: '#D9899E',
        gold: '#F4D7A1',
        cream: '#FFF7EC',
        ink: '#1F1F24',
        sky: '#72C7E7',
        green: '#7BC47F',
        coral: '#FF7A6B',
        yellow: '#F6C85F',
        lavender: '#BFA7F2',
        peach: '#FFC6A8',
        teal: '#2F7D8C',
      },
      fontFamily: {
        heading: ['Poppins', 'sans-serif'],
        body: ['Nunito Sans', 'sans-serif'],
        accent: ['Fraunces', 'serif'],
      },
      boxShadow: {
        soft: '0 18px 60px rgba(62, 36, 55, 0.12)',
        card: '0 12px 36px rgba(62, 36, 55, 0.10)',
      },
      borderRadius: {
        '4xl': '2rem',
      },
    },
  },
  plugins: [],
}
