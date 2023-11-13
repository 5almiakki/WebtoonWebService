import type { Metadata } from 'next'
import { Inter } from 'next/font/google'
import './globals.css'
import ReactPlayer from 'react-player'
import Background from './components/BackgroundPage'
import { Head } from 'next/document'
import Navbar from './components/Navbar'

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: 'Create Next App',
  description: 'Generated by create next app',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
        
        <body className={inter.className}>
          <Background></Background>
          <Navbar></Navbar>
            {children}
          <div id = "modal"></div>
        </body>
    </html>
  )
}
