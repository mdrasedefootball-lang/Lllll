package com.example.data.books

import androidx.compose.ui.graphics.Color
import com.example.data.models.ColorableRegion
import com.example.data.models.ColoringBook
import com.example.data.models.ColoringPage

fun getBook3Dragons(): ColoringBook {
    val page1Regions = listOf(
        // Friendly Little Dragon
        // Wings
        ColorableRegion("dragon_wing_l", "Dragon Wing Left", "M 240 240 C 160 170 90 200 110 280 C 130 330 190 320 235 295 Z"),
        ColorableRegion("dragon_wing_web_l", "Wing Webbing Left", "M 130 240 C 150 220 180 230 190 270 C 160 275 140 260 130 240 Z"),
        ColorableRegion("dragon_wing_r", "Dragon Wing Right", "M 360 240 C 440 170 510 200 490 280 C 470 330 410 320 365 295 Z"),
        ColorableRegion("dragon_wing_web_r", "Wing Webbing Right", "M 470 240 C 450 220 420 230 410 270 C 440 275 460 260 470 240 Z"),

        // Dragon Tail
        ColorableRegion("dragon_tail", "Dragon Spiky Tail", "M 350 420 C 430 430 490 380 490 320 C 470 320 440 370 360 385 Z"),
        ColorableRegion("dragon_tail_spade", "Dragon Tail Heart Arrow", "M 490 320 L 515 305 L 515 335 Z"),

        // Dragon Head & Horns
        ColorableRegion("dragon_horn_l", "Dragon Horn Left", "M 250 170 C 230 110 270 100 275 160 Z"),
        ColorableRegion("dragon_horn_r", "Dragon Horn Right", "M 350 170 C 370 110 330 100 325 160 Z"),
        ColorableRegion("dragon_head", "Dragon Chubby Head", "M 240 190 C 230 140 370 140 360 190 C 385 230 380 280 300 280 C 220 280 215 230 240 190 Z"),
        ColorableRegion("dragon_snout", "Dragon Friendly Snout", "M 255 235 C 265 220 335 220 345 235 C 350 275 250 275 255 235 Z"),
        ColorableRegion("dragon_nostril_l", "Left Smoke Nostril", "M 280 245 C 275 245 275 253 280 253 C 285 253 285 245 280 245 Z"),
        ColorableRegion("dragon_nostril_r", "Right Smoke Nostril", "M 320 245 C 315 245 315 253 320 253 C 325 253 325 245 320 245 Z"),
        ColorableRegion("dragon_smile", "Dragon Tooth Smile", "M 290 265 Q 300 275 310 265 Q 300 268 290 265 Z"),

        // Big Expressive Eyes
        ColorableRegion("dragon_eye_l", "Dragon Big Eye L", "M 265 195 C 265 180 285 180 285 195 C 285 210 265 210 265 195 Z"),
        ColorableRegion("dragon_pupil_l", "Pupil Sparkle L", "M 272 190 C 272 186 278 186 278 190 C 278 194 272 194 272 190 Z"),
        ColorableRegion("dragon_eye_r", "Dragon Big Eye R", "M 315 195 C 315 180 335 180 335 195 C 335 210 315 210 315 195 Z"),
        ColorableRegion("dragon_pupil_r", "Pupil Sparkle R", "M 322 190 C 322 186 328 186 328 190 C 328 194 322 194 322 190 Z"),

        // Dragon Body & Belly
        ColorableRegion("dragon_body", "Dragon Round Tummy", "M 250 275 C 220 320 220 420 270 450 C 330 460 380 420 350 275 Z"),
        ColorableRegion("dragon_belly", "Dragon Yellow Belly Scales", "M 270 300 C 260 350 260 410 285 435 C 315 435 340 410 330 350 C 330 300 270 300 270 300 Z"),
        ColorableRegion("dragon_belly_stripe_1", "Belly Stripe Top", "M 275 335 Q 300 345 325 335 Q 300 340 275 335 Z"),
        ColorableRegion("dragon_belly_stripe_2", "Belly Stripe Mid", "M 270 375 Q 300 385 330 375 Q 300 380 270 375 Z"),

        // Arms & Feet
        ColorableRegion("dragon_arm_l", "Cute Claws Left", "M 245 310 C 225 325 215 350 235 360 C 245 350 255 330 252 312 Z"),
        ColorableRegion("dragon_arm_r", "Cute Claws Right", "M 355 310 C 375 325 385 350 365 360 C 355 350 345 330 348 312 Z"),
        ColorableRegion("dragon_foot_l", "Dragon Foot Left", "M 240 440 C 220 470 275 480 285 450 Z"),
        ColorableRegion("dragon_foot_r", "Dragon Foot Right", "M 315 450 C 325 480 380 470 360 440 Z"),

        // Tiny Fire Smoke Puff & Treasure Gem
        ColorableRegion("fire_puff_outer", "Fire Magic Sparkle", "M 180 240 C 160 210 190 190 200 210 C 215 200 225 220 215 235 C 220 250 200 260 180 240 Z"),
        ColorableRegion("fire_puff_core", "Fire Magic Core", "M 190 230 C 180 220 195 210 200 220 C 205 215 210 225 205 232 Z"),
        ColorableRegion("treasure_gem", "Sparkling Cave Crystal", "M 110 450 L 130 420 L 150 450 L 130 480 Z"),
        ColorableRegion("cave_rock_ground", "Cave Treasure Floor", "M 0 490 Q 300 450 600 490 L 600 600 L 0 600 Z")
    )

    val page2Regions = listOf(
        // Cosmic Rocket Explorer
        // Deep Space Planets & Stars
        ColorableRegion("saturn_planet", "Ringed Saturn Planet", "M 100 120 C 80 120 80 160 100 160 C 120 160 120 120 100 120 Z"),
        ColorableRegion("saturn_ring", "Cosmic Planet Ring", "M 60 140 C 60 125 140 125 140 140 C 140 155 60 155 60 140 Z"),
        ColorableRegion("space_moon", "Crescent Moon", "M 480 80 C 450 80 450 140 480 140 C 470 125 470 95 480 80 Z"),
        ColorableRegion("space_star_1", "Space Twinkle 1", "M 230 70 L 235 80 L 246 81 L 238 89 L 240 100 L 230 94 L 220 100 L 222 89 L 214 81 L 225 80 Z"),
        ColorableRegion("space_star_2", "Space Twinkle 2", "M 380 80 L 385 90 L 396 91 L 388 99 L 390 110 L 380 104 L 370 110 L 372 99 L 364 91 L 375 90 Z"),

        // Rocket Ship Body
        ColorableRegion("rocket_nose_cone", "Rocket Nose Cone", "M 260 180 C 275 100 325 100 340 180 Z"),
        ColorableRegion("rocket_body_upper", "Rocket Hull Upper", "M 250 180 L 240 270 L 360 270 L 350 180 Z"),
        ColorableRegion("rocket_body_lower", "Rocket Hull Lower", "M 240 270 L 235 370 L 365 370 L 360 270 Z"),
        ColorableRegion("rocket_stripe", "Speed Racing Stripe", "M 240 260 L 238 280 L 362 280 L 360 260 Z"),

        // Cockpit & Cute Alien Astronaut
        ColorableRegion("rocket_window_frame", "Porthole Window Rim", "M 300 200 C 270 200 270 260 300 260 C 330 260 330 200 300 200 Z"),
        ColorableRegion("rocket_window_glass", "Window Glass", "M 300 208 C 278 208 278 252 300 252 C 322 252 322 208 300 208 Z"),
        ColorableRegion("alien_head", "Friendly Green Alien", "M 300 215 C 285 215 285 245 300 245 C 315 245 315 215 300 215 Z"),
        ColorableRegion("alien_eye_big", "Alien Big Cyclops Eye", "M 300 223 C 294 223 294 233 300 233 C 306 233 306 223 300 223 Z"),
        ColorableRegion("alien_antenna", "Alien Spring Antenna", "M 300 215 L 300 210 C 298 207 302 207 300 210 Z"),

        // Fins & Thruster
        ColorableRegion("rocket_fin_l", "Rocket Booster Fin Left", "M 235 340 L 170 410 L 230 400 Z"),
        ColorableRegion("rocket_fin_r", "Rocket Booster Fin Right", "M 365 340 L 430 410 L 370 400 Z"),
        ColorableRegion("rocket_engine_nozzle", "Thruster Nozzle", "M 265 370 L 255 400 L 345 400 L 335 370 Z"),

        // Rocket Blast Fire
        ColorableRegion("rocket_fire_outer", "Blaster Fire Outer", "M 255 400 C 255 480 300 520 300 550 C 300 520 345 480 345 400 Z"),
        ColorableRegion("rocket_fire_inner", "Blaster Flame Core", "M 275 400 C 275 450 300 480 300 500 C 300 480 325 450 325 400 Z"),

        // Moon Surface Ground
        ColorableRegion("moon_surface", "Lunar Crater Surface", "M 0 520 Q 300 480 600 520 L 600 600 L 0 600 Z"),
        ColorableRegion("crater_1", "Moon Crater Left", "M 100 550 C 85 550 85 570 100 570 C 115 570 115 550 100 550 Z"),
        ColorableRegion("crater_2", "Moon Crater Right", "M 480 540 C 460 540 460 565 480 565 C 500 565 500 540 480 540 Z")
    )

    val page3Regions = listOf(
        // Whimsical Robot Buddy
        // Antenna
        ColorableRegion("bot_antenna_rod", "Antenna Stem", "M 297 120 L 297 160 L 303 160 L 303 120 Z"),
        ColorableRegion("bot_antenna_ball", "Antenna Glowing Bulb", "M 300 100 C 285 100 285 125 300 125 C 315 125 315 100 300 100 Z"),
        ColorableRegion("bot_ear_l", "Bolt Ear Left", "M 230 190 L 210 195 L 210 215 L 230 220 Z"),
        ColorableRegion("bot_ear_r", "Bolt Ear Right", "M 370 190 L 390 195 L 390 215 L 370 220 Z"),

        // Robot Head
        ColorableRegion("bot_head_box", "Robot Head Screen", "M 230 160 C 230 150 370 150 370 160 L 370 245 C 370 255 230 255 230 245 Z"),
        ColorableRegion("bot_eye_screen", "Visor Display", "M 245 175 L 355 175 L 355 215 L 245 215 Z"),
        ColorableRegion("bot_eye_l", "Digital Camera Eye L", "M 270 185 C 260 185 260 205 270 205 C 280 205 280 185 270 185 Z"),
        ColorableRegion("bot_eye_r", "Digital Camera Eye R", "M 330 185 C 320 185 320 205 330 205 C 340 205 340 185 330 185 Z"),
        ColorableRegion("bot_smile", "Speaker Grill Mouth", "M 275 225 L 325 225 L 320 235 L 280 235 Z"),

        // Neck
        ColorableRegion("bot_neck", "Accordion Neck", "M 285 255 L 285 270 L 315 270 L 315 255 Z"),

        // Robot Torso
        ColorableRegion("bot_body_chest", "Chassis Body", "M 225 270 C 225 265 375 265 375 270 L 370 410 C 370 415 230 415 230 410 Z"),
        ColorableRegion("bot_screen_belly", "Heart Monitor Panel", "M 250 285 L 350 285 L 350 340 L 250 340 Z"),
        ColorableRegion("bot_heart", "Happy Battery Heart", "M 300 295 C 290 288 280 300 300 318 C 320 300 310 288 300 295 Z"),
        ColorableRegion("bot_meter_gauge", "Energy Gauge Dial", "M 270 360 C 270 345 330 345 330 360 Z"),
        ColorableRegion("bot_button_1", "Control Button 1", "M 255 385 C 250 385 250 395 255 395 C 260 395 260 385 255 385 Z"),
        ColorableRegion("bot_button_2", "Control Button 2", "M 280 385 C 275 385 275 395 280 395 C 285 395 285 385 280 385 Z"),
        ColorableRegion("bot_button_3", "Control Button 3", "M 305 385 C 300 385 300 395 305 395 C 310 395 310 385 305 385 Z"),
        ColorableRegion("bot_button_4", "Control Button 4", "M 330 385 C 325 385 325 395 330 395 C 335 395 335 385 330 385 Z"),

        // Arms & Claws
        ColorableRegion("bot_arm_l", "Spring Arm Left", "M 225 285 C 185 295 170 340 185 365 L 195 355 C 185 335 195 305 225 300 Z"),
        ColorableRegion("bot_claw_l", "Magnetic Hand Left", "M 185 365 C 170 375 195 395 205 380 Z"),
        ColorableRegion("bot_arm_r", "Waving Arm Right", "M 375 285 C 415 280 435 240 445 220 L 435 215 C 425 235 405 270 375 298 Z"),
        ColorableRegion("bot_claw_r", "Waving Hand Right", "M 445 220 C 465 210 450 190 435 205 Z"),

        // Legs & Rollers
        ColorableRegion("bot_leg_l", "Piston Leg Left", "M 255 415 L 255 470 L 275 470 L 275 415 Z"),
        ColorableRegion("bot_foot_l", "Magnetic Foot Left", "M 245 470 L 285 470 L 290 495 L 240 495 Z"),
        ColorableRegion("bot_leg_r", "Piston Leg Right", "M 325 415 L 325 470 L 345 470 L 345 415 Z"),
        ColorableRegion("bot_foot_r", "Magnetic Foot Right", "M 315 470 L 355 470 L 360 495 L 310 495 Z"),

        // Robot Puppy Companion
        ColorableRegion("dog_head", "Robo-Dog Cute Head", "M 460 430 L 495 430 L 490 460 L 455 460 Z"),
        ColorableRegion("dog_ear", "Robo-Dog Antenna Ear", "M 460 430 L 450 410 L 465 418 Z"),
        ColorableRegion("dog_eye", "Robo-Dog LED Eye", "M 475 440 C 472 440 472 446 475 446 C 478 446 478 440 475 440 Z"),
        ColorableRegion("dog_body", "Robo-Dog Body", "M 480 460 L 530 460 L 525 500 L 475 500 Z"),
        ColorableRegion("dog_tail", "Spring Tail", "M 530 465 L 545 450 L 540 470 Z"),

        ColorableRegion("lab_floor", "Inventor Workshop Floor", "M 0 495 L 600 495 L 600 600 L 0 600 Z")
    )

    return ColoringBook(
        id = "book_dragons",
        title = "Dragons, Monsters, Spaceships & More",
        shortTitle = "Dragons & Space",
        iconName = "RocketLaunch",
        accentColor = Color(0xFF34C759),
        pages = listOf(
            ColoringPage("dragon_page_1", "Friendly Little Dragon", "Chubby baby dragon with horns, wings, belly scales & fire spark", 600f, 600f, page1Regions),
            ColoringPage("dragon_page_2", "Cosmic Rocket Explorer", "Retro spaceship blasting past Saturn with cute alien astronaut", 600f, 600f, page2Regions),
            ColoringPage("dragon_page_3", "Whimsical Robot Buddy", "Smiling retro robot with gauge belly, antenna & robo-puppy", 600f, 600f, page3Regions)
        )
    )
}
