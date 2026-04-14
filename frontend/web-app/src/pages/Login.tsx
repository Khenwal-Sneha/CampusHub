import React, { useState } from "react";
import { motion } from "framer-motion";

type LoginType = "student" | "vendor" | "admin";

const Login: React.FC = () => {
  const [type, setType] = useState<LoginType>("student");

  return (
    <div className="min-h-screen flex items-center justify-center bg-[#0B0F1A] px-4">

      {/* 🌌 Background Glow */}
      <div className="absolute w-[500px] h-[500px] bg-indigo-500/20 blur-3xl rounded-full top-10 left-10"></div>
      <div className="absolute w-[400px] h-[400px] bg-purple-500/20 blur-3xl rounded-full bottom-10 right-10"></div>

      {/* 🧊 Glass Card */}
      <div className="relative w-full max-w-md p-8 rounded-2xl
        bg-white/5 backdrop-blur-xl border border-white/10 shadow-2xl">

        {/* 🔥 Title */}
        <h1 className="text-3xl font-bold text-center mb-2">
          <span className="bg-gradient-to-r from-indigo-400 via-purple-400 to-pink-400 bg-clip-text text-transparent">
            Welcome Back
          </span>
        </h1>

        <p className="text-gray-400 text-center mb-6 text-sm">
          Login to CampusHub
        </p>

        {/* 🔘 Role Selector */}
        <div className="flex justify-between mb-6 bg-white/5 p-1 rounded-xl">
          
          {["student", "vendor", "admin"].map((role) => (
            <button
              key={role}
              onClick={() => setType(role as LoginType)}
              className={`w-full py-2 text-sm rounded-lg transition ${
                type === role
                  ? "bg-gradient-to-r from-indigo-500 to-purple-500 text-white"
                  : "text-gray-400 hover:text-white"
              }`}
            >
              {role.toUpperCase()}
            </button>
          ))}

        </div>

        {/* ✏️ Input Fields */}
        <div className="space-y-4">
          <input
            type="email"
            placeholder="Email"
            className="w-full px-4 py-3 rounded-xl bg-white/5 border border-white/10
            text-white outline-none focus:border-indigo-500 transition"
          />

          <input
            type="password"
            placeholder="Password"
            className="w-full px-4 py-3 rounded-xl bg-white/5 border border-white/10
            text-white outline-none focus:border-indigo-500 transition"
          />
        </div>

        {/* 🔘 Login Button */}
        <motion.button
          whileHover={{ scale: 1.05 }}
          whileTap={{ scale: 0.95 }}
          className="w-full mt-6 py-3 rounded-xl font-semibold text-white
          bg-gradient-to-r from-indigo-500 to-purple-500
          shadow-lg hover:shadow-xl transition"
        >
          Login as {type}
        </motion.button>

        {/* 🔗 Footer Links */}
        <div className="mt-5 text-center text-xs text-gray-500">
          Forgot password? • Create account
        </div>

      </div>
    </div>
  );
};

export default Login;