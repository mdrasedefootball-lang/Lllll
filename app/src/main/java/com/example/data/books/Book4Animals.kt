package com.example.data.books

import androidx.compose.ui.graphics.Color
import com.example.data.models.ColorableRegion
import com.example.data.models.ColoringBook
import com.example.data.models.ColoringPage

fun getBook4Animals(): ColoringBook {
    val page1Regions = listOf(
        // Happy Jungle Lion Cub
        ColorableRegion("safari_sun", "Warm Safari Sun", "M 100 90 C 70 90 70 150 100 150 C 130 150 130 90 100 90 Z"),
        ColorableRegion("safari_sun_ray1", "Sun Ray 1", "M 140 100 L 165 90 L 145 115 Z"),
        ColorableRegion("safari_sun_ray2", "Sun Ray 2", "M 125 155 L 140 180 L 110 165 Z"),

        // Fluffy Mane (Petals around head)
        ColorableRegion("mane_top", "Mane Top Tuft", "M 270 140 C 260 90 340 90 330 140 Z"),
        ColorableRegion("mane_top_l", "Mane Top-Left", "M 230 160 C 190 120 250 100 270 140 Z"),
        ColorableRegion("mane_top_r", "Mane Top-Right", "M 330 140 C 350 100 410 120 370 160 Z"),
        ColorableRegion("mane_mid_l", "Mane Mid-Left", "M 205 210 C 150 190 170 260 215 260 Z"),
        ColorableRegion("mane_mid_r", "Mane Mid-Right", "M 385 260 C 430 260 450 190 395 210 Z"),
        ColorableRegion("mane_bot_l", "Mane Bot-Left", "M 225 270 C 180 290 220 350 260 320 Z"),
        ColorableRegion("mane_bot_r", "Mane Bot-Right", "M 340 320 C 380 350 420 290 375 270 Z"),
        ColorableRegion("mane_chin", "Mane Chin Ruffle", "M 260 320 C 280 360 320 360 340 320 Z"),

        // Ears
        ColorableRegion("lion_ear_l_out", "Left Ear Outer", "M 240 170 C 220 130 260 125 265 160 Z"),
        ColorableRegion("lion_ear_l_in", "Left Ear Inner", "M 245 165 C 235 140 255 135 258 158 Z"),
        ColorableRegion("lion_ear_r_out", "Right Ear Outer", "M 360 170 C 380 130 340 125 335 160 Z"),
        ColorableRegion("lion_ear_r_in", "Right Ear Inner", "M 355 165 C 365 140 345 135 342 158 Z"),

        // Lion Face
        ColorableRegion("lion_face", "Lion Cub Face", "M 240 170 C 360 170 370 230 360 290 C 340 315 260 315 240 290 C 230 230 230 175 240 170 Z"),
        ColorableRegion("lion_muzzle", "Puffy Whisker Pad", "M 265 245 C 275 235 325 235 335 245 C 340 280 260 280 265 245 Z"),
        ColorableRegion("lion_nose", "Cute Brown Heart Nose", "M 292 245 L 308 245 L 300 255 Z"),
        ColorableRegion("lion_smile", "Happy Cub Smile", "M 292 265 Q 300 272 308 265 Q 300 267 292 265 Z"),

        // Big Eyes
        ColorableRegion("lion_eye_l", "Cub Eye Left", "M 270 215 C 270 200 288 200 288 215 C 288 230 270 230 270 215 Z"),
        ColorableRegion("lion_pupil_l", "Eye Sparkle L", "M 276 210 C 276 205 282 205 282 210 C 282 215 276 215 276 210 Z"),
        ColorableRegion("lion_eye_r", "Cub Eye Right", "M 312 215 C 312 200 330 200 330 215 C 330 230 312 230 312 215 Z"),
        ColorableRegion("lion_pupil_r", "Eye Sparkle R", "M 318 210 C 318 205 324 205 324 210 C 324 215 318 215 318 210 Z"),

        // Body & Paws
        ColorableRegion("lion_body", "Lion Cub Body", "M 255 315 C 230 350 230 430 265 460 C 335 465 370 430 345 315 Z"),
        ColorableRegion("lion_chest", "White Chest Fur", "M 280 325 C 275 370 325 370 320 325 Z"),
        ColorableRegion("lion_paw_l", "Front Left Paw", "M 245 425 C 225 450 270 480 285 450 Z"),
        ColorableRegion("lion_paw_r", "Front Right Paw", "M 315 450 C 330 480 375 450 355 425 Z"),
        ColorableRegion("lion_toe_pad_l", "Left Paw Pad", "M 255 450 C 250 450 250 460 255 460 C 260 460 260 450 255 450 Z"),
        ColorableRegion("lion_toe_pad_r", "Right Paw Pad", "M 345 450 C 340 450 340 460 345 460 C 350 460 350 450 345 450 Z"),

        // Tail
        ColorableRegion("lion_tail", "Tail Curve", "M 350 420 C 420 420 440 370 430 330 C 420 335 410 395 355 395 Z"),
        ColorableRegion("lion_tail_puff", "Tail Fluffy Tuft", "M 430 330 C 445 310 460 340 440 355 Z"),

        // Jungle Leaves & Flowers
        ColorableRegion("jungle_leaf_l", "Monstera Leaf Left", "M 50 420 C 30 350 110 340 140 390 C 120 430 80 440 50 420 Z"),
        ColorableRegion("jungle_flower", "Tropical Flower", "M 490 440 C 470 420 510 400 520 425 C 540 410 560 430 545 445 C 560 465 535 480 520 460 C 500 475 485 455 490 440 Z"),
        ColorableRegion("jungle_ground", "Savannah Grass", "M 0 480 Q 300 450 600 480 L 600 600 L 0 600 Z")
    )

    val page2Regions = listOf(
        // Charming Panda Bear
        // Panda Ears
        ColorableRegion("panda_ear_l", "Panda Black Ear Left", "M 220 180 C 190 140 240 120 255 160 Z"),
        ColorableRegion("panda_ear_r", "Panda Black Ear Right", "M 380 180 C 410 140 360 120 345 160 Z"),

        // Panda Head
        ColorableRegion("panda_head", "Panda Round Face", "M 230 180 C 370 180 380 230 375 285 C 365 330 235 330 225 285 C 220 230 220 185 230 180 Z"),

        // Big Cute Panda Eye Patches
        ColorableRegion("panda_patch_l", "Black Eye Patch Left", "M 250 215 C 240 200 275 190 285 215 C 290 235 260 245 250 215 Z"),
        ColorableRegion("panda_eye_l", "Sparkling Eye Left", "M 262 215 C 262 208 272 208 272 215 C 272 222 262 222 262 215 Z"),
        ColorableRegion("panda_pupil_l", "Left Glint", "M 265 212 C 265 209 269 209 269 212 C 269 215 265 215 265 212 Z"),

        ColorableRegion("panda_patch_r", "Black Eye Patch Right", "M 350 215 C 360 200 325 190 315 215 C 310 235 340 245 350 215 Z"),
        ColorableRegion("panda_eye_r", "Sparkling Eye Right", "M 328 215 C 328 208 338 208 338 215 C 338 222 328 222 328 215 Z"),
        ColorableRegion("panda_pupil_r", "Right Glint", "M 331 212 C 331 209 335 209 335 212 C 335 215 331 215 331 212 Z"),

        ColorableRegion("panda_nose", "Panda Sweet Nose", "M 293 250 L 307 250 L 300 260 Z"),
        ColorableRegion("panda_smile", "Panda Happy Smile", "M 292 270 Q 300 278 308 270 Q 300 273 292 270 Z"),
        ColorableRegion("panda_blush_l", "Pink Cheek L", "M 235 255 C 230 255 230 265 235 265 C 240 265 240 255 235 255 Z"),
        ColorableRegion("panda_blush_r", "Pink Cheek R", "M 365 255 C 360 255 360 265 365 265 C 370 265 370 255 365 255 Z"),

        // Torso & Vest
        ColorableRegion("panda_vest_shoulder", "Black Shoulder Vest", "M 230 315 L 210 380 L 390 380 L 370 315 Z"),
        ColorableRegion("panda_tummy", "Panda White Belly", "M 240 375 C 230 420 240 460 265 470 C 335 470 370 420 360 375 Z"),
        ColorableRegion("panda_heart_patch", "Belly Heart Badge", "M 300 395 C 290 385 275 400 300 420 C 325 400 310 385 300 395 Z"),

        // Arms & Paws
        ColorableRegion("panda_arm_l", "Black Arm Left", "M 225 320 C 190 340 185 390 220 405 C 230 380 235 345 235 330 Z"),
        ColorableRegion("panda_arm_r", "Black Arm Right", "M 375 320 C 410 340 415 390 380 405 C 370 380 365 345 365 330 Z"),

        // Legs
        ColorableRegion("panda_leg_l", "Black Leg Left", "M 220 450 C 200 470 240 515 265 490 C 270 470 250 440 220 450 Z"),
        ColorableRegion("panda_leg_r", "Black Leg Right", "M 380 450 C 400 470 360 515 335 490 C 330 470 350 440 380 450 Z"),

        // Bamboo Stalk
        ColorableRegion("bamboo_stalk_1", "Bamboo Joint 1", "M 410 200 L 400 300 L 415 300 L 425 200 Z"),
        ColorableRegion("bamboo_stalk_2", "Bamboo Joint 2", "M 398 305 L 390 410 L 405 410 L 413 305 Z"),
        ColorableRegion("bamboo_leaf_1", "Bamboo Leaf 1", "M 425 210 C 455 190 470 220 440 230 Z"),
        ColorableRegion("bamboo_leaf_2", "Bamboo Leaf 2", "M 415 280 C 445 270 460 300 430 305 Z"),

        // Ground Pebbles
        ColorableRegion("bamboo_ground", "Zen Moss Lawn", "M 0 500 Q 300 465 600 500 L 600 600 L 0 600 Z"),
        ColorableRegion("pebble_1", "Smooth Pebble 1", "M 120 535 C 100 535 100 555 120 555 C 140 555 140 535 120 535 Z"),
        ColorableRegion("pebble_2", "Smooth Pebble 2", "M 460 525 C 440 525 440 545 460 545 C 480 545 480 525 460 525 Z")
    )

    val page3Regions = listOf(
        // Undersea Little Turtle
        ColorableRegion("ocean_wave_top", "Sunlit Surface Ripple", "M 0 60 Q 150 40 300 60 Q 450 80 600 60 L 600 0 L 0 0 Z"),

        // Shell - Geometric Plates
        ColorableRegion("shell_rim", "Turtle Shell Border Rim", "M 230 200 C 170 230 160 370 230 420 C 370 450 440 370 410 230 C 370 190 280 180 230 200 Z"),
        ColorableRegion("shell_plate_center", "Hexagon Plate Center", "M 270 280 L 310 270 L 330 305 L 310 340 L 270 340 L 250 305 Z"),
        ColorableRegion("shell_plate_top", "Plate Top", "M 270 280 L 310 270 L 305 220 L 265 230 Z"),
        ColorableRegion("shell_plate_right", "Plate Right", "M 310 270 L 330 305 L 380 295 L 365 250 Z"),
        ColorableRegion("shell_plate_bot_r", "Plate Bottom-Right", "M 330 305 L 310 340 L 345 385 L 380 350 Z"),
        ColorableRegion("shell_plate_bot", "Plate Bottom", "M 310 340 L 270 340 L 265 390 L 310 395 Z"),
        ColorableRegion("shell_plate_bot_l", "Plate Bottom-Left", "M 270 340 L 250 305 L 205 325 L 225 375 Z"),
        ColorableRegion("shell_plate_left", "Plate Left", "M 250 305 L 270 280 L 230 240 L 205 270 Z"),

        // Turtle Head & Neck
        ColorableRegion("turtle_head", "Turtle Smiling Head", "M 370 200 C 440 170 460 250 410 270 Z"),
        ColorableRegion("turtle_eye", "Turtle Big Eye", "M 410 215 C 405 215 405 228 410 228 C 418 228 418 215 410 215 Z"),
        ColorableRegion("turtle_pupil", "Turtle Glint", "M 413 218 C 411 218 411 222 413 222 C 415 222 415 218 413 218 Z"),
        ColorableRegion("turtle_smile", "Turtle Beak Smile", "M 425 240 Q 435 245 440 235 Q 435 242 425 240 Z"),

        // Flippers
        ColorableRegion("flipper_front_r", "Front Right Flipper", "M 370 240 C 450 250 510 320 460 360 C 415 350 380 310 370 270 Z"),
        ColorableRegion("flipper_front_l", "Front Left Flipper", "M 240 190 C 230 110 160 120 170 195 C 190 220 220 220 240 190 Z"),
        ColorableRegion("flipper_back_r", "Back Right Flipper", "M 340 400 C 390 440 370 480 330 460 Z"),
        ColorableRegion("flipper_back_l", "Back Left Flipper", "M 200 370 C 160 410 170 450 210 430 Z"),
        ColorableRegion("turtle_tail", "Turtle Cute Tail", "M 260 430 L 275 465 L 290 430 Z"),

        // Little Clownfish Friend
        ColorableRegion("fish_body", "Clownfish Orange Body", "M 100 280 C 70 280 70 330 100 330 C 130 330 140 280 100 280 Z"),
        ColorableRegion("fish_tail", "Clownfish Tail Fin", "M 70 305 L 45 285 L 45 325 Z"),
        ColorableRegion("fish_stripe", "Clownfish White Stripe", "M 95 285 L 90 325 L 105 325 L 108 285 Z"),
        ColorableRegion("fish_eye", "Fish Eye", "M 120 295 C 117 295 117 302 120 302 C 123 302 123 295 120 295 Z"),

        // Bubbles
        ColorableRegion("bubble_1", "Air Bubble 1", "M 480 140 C 470 140 470 155 480 155 C 490 155 490 140 480 140 Z"),
        ColorableRegion("bubble_2", "Air Bubble 2", "M 450 110 C 442 110 442 122 450 122 C 458 122 458 110 450 110 Z"),

        // Sea Coral Reef Bottom
        ColorableRegion("seaweed_ribbon_l", "Green Kelp Ribbon L", "M 40 600 C 60 530 20 480 50 420 C 60 470 35 520 70 600 Z"),
        ColorableRegion("seaweed_ribbon_r", "Green Kelp Ribbon R", "M 530 600 C 560 520 510 470 540 400 C 550 460 530 520 570 600 Z"),
        ColorableRegion("sea_bed", "Ocean Sandy Bed", "M 0 540 Q 300 510 600 540 L 600 600 L 0 600 Z")
    )

    return ColoringBook(
        id = "book_animals",
        title = "Animals",
        shortTitle = "Wild Animals",
        iconName = "CrueltyFree",
        accentColor = Color(0xFFFF9500),
        pages = listOf(
            ColoringPage("animal_page_1", "Happy Jungle Lion Cub", "Smiling baby lion with fluffy petal mane and savannah leaves", 600f, 600f, page1Regions),
            ColoringPage("animal_page_2", "Charming Panda Bear", "Cute chubby panda holding leafy bamboo shoot with heart badge", 600f, 600f, page2Regions),
            ColoringPage("animal_page_3", "Undersea Little Turtle", "Gentle swimming sea turtle with hexagon shell and clownfish", 600f, 600f, page3Regions)
        )
    )
}
