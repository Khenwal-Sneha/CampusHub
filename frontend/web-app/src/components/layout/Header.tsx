import React from "react";
import { motion } from "framer-motion";
import logo from "../../assets/logo.png";
import { useNavigate } from "react-router-dom";

const Header: React.FC = () => {
  const navigate = useNavigate(); // ✅ MUST be inside component

  return (
    <header
      className="w-full px-4 sm:px-6 py-3 sm:py-4 flex items-center justify-between
      bg-white/5 backdrop-blur-xl border-b border-white/10 shadow-lg"
    >
      {/* 🔥 LOGO ONLY BRAND */}
      <div className="flex items-center group cursor-pointer">

        <div className="relative">
          {/* Glow layer */}
          <div className="absolute inset-0 rounded-full bg-indigo-500/30 blur-2xl opacity-60 group-hover:opacity-100 transition"></div>

          {/* Logo */}
          <img
            src={logo}
            alt="CampusHub Logo"
            className="relative z-10 w-16em h-30 sm:w-16em sm:h-30 object-contain
            drop-shadow-[0_0_20px_rgba(99,102,241,0.8)]
            transition-transform duration-300 group-hover:scale-110"
          />
        </div>
      </div>

      {/* 🚀 Navigation */}
      <nav className="hidden md:flex items-center gap-6 lg:gap-8 text-gray-300 text-sm lg:text-base">
        <a href="#" className="hover:text-white transition">Dashboard</a>
        <a href="#" className="hover:text-white transition">Vendors</a>
        <a href="#" className="hover:text-white transition">Orders</a>
      </nav>

      {/* 🔘 CTA Button */}
      <motion.button
        whileHover={{ scale: 1.05 }}
        whileTap={{ scale: 0.95 }}
        onClick={() => navigate("/login")}
        className="px-4 sm:px-5 py-2 rounded-xl font-semibold text-white text-sm sm:text-base
        bg-gradient-to-r from-indigo-500 to-purple-500
        shadow-lg hover:shadow-xl transition-all duration-300"
      >
        Login
      </motion.button>
    </header>
  );
};

export default Header;