package com.example.data.books

import androidx.compose.ui.graphics.Color
import com.example.data.models.ColorableRegion
import com.example.data.models.ColoringBook
import com.example.data.models.ColoringPage

fun getBook2Unicorns(): ColoringBook {
    val page1Regions = listOf(
        // Rainbow Arches
        ColorableRegion("rainbow_red", "Rainbow Red Arch", "M 50 250 C 50 110 550 110 550 250 L 520 250 C 520 135 80 135 80 250 Z"),
        ColorableRegion("rainbow_orange", "Rainbow Orange Arch", "M 80 250 C 80 135 520 135 520 250 L 490 250 C 490 160 110 160 110 250 Z"),
        ColorableRegion("rainbow_yellow", "Rainbow Yellow Arch", "M 110 250 C 110 160 490 160 490 250 L 460 250 C 460 185 140 185 140 250 Z"),
        ColorableRegion("rainbow_green", "Rainbow Green Arch", "M 140 250 C 140 185 460 185 460 250 L 430 250 C 430 210 170 210 170 250 Z"),
        ColorableRegion("rainbow_blue", "Rainbow Blue Arch", "M 170 250 C 170 210 430 210 430 250 L 400 250 C 400 230 200 230 200 250 Z"),

        // Rainbow Base Clouds
        ColorableRegion("cloud_rainbow_l", "Cloud Left", "M 30 260 C 20 240 40 220 70 230 C 90 215 120 225 130 245 C 150 250 155 275 140 290 C 120 300 50 300 30 260 Z"),
        ColorableRegion("cloud_rainbow_r", "Cloud Right", "M 470 260 C 460 240 480 220 510 230 C 530 215 560 225 570 245 C 590 250 595 275 580 290 C 560 300 490 300 470 260 Z"),

        // Stars
        ColorableRegion("star_unicorn_1", "Sky Star Left", "M 100 80 L 108 95 L 125 96 L 112 108 L 116 125 L 100 115 L 84 125 L 88 108 L 75 96 L 92 95 Z"),
        ColorableRegion("star_unicorn_2", "Sky Star Right", "M 500 80 L 508 95 L 525 96 L 512 108 L 516 125 L 500 115 L 484 125 L 488 108 L 475 96 L 492 95 Z"),

        // Cute Unicorn
        // Horn
        ColorableRegion("unicorn_horn_base", "Golden Magic Horn", "M 290 140 L 300 70 L 310 140 Z"),
        ColorableRegion("unicorn_horn_swirl", "Horn Spiral Stripe", "M 295 105 L 305 95 L 307 103 L 298 115 Z"),

        // Ears
        ColorableRegion("uni_ear_l_outer", "Unicorn Left Ear", "M 255 170 C 240 125 270 120 275 160 Z"),
        ColorableRegion("uni_ear_l_inner", "Unicorn Inner Ear", "M 260 160 C 250 135 268 135 270 155 Z"),
        ColorableRegion("uni_ear_r_outer", "Unicorn Right Ear", "M 325 170 C 340 125 310 120 305 160 Z"),

        // Mane Locks
        ColorableRegion("uni_mane_1", "Mane Swirl Pastel Pink", "M 270 155 C 230 165 215 210 240 230 C 235 200 260 185 280 175 Z"),
        ColorableRegion("uni_mane_2", "Mane Swirl Pastel Purple", "M 260 210 C 210 230 200 290 235 305 C 225 270 245 240 265 230 Z"),
        ColorableRegion("uni_mane_3", "Mane Swirl Pastel Cyan", "M 250 270 C 190 290 190 370 230 380 C 220 340 240 310 260 295 Z"),

        // Head & Face
        ColorableRegion("uni_head", "Unicorn Friendly Face", "M 265 170 C 335 170 345 220 340 260 C 335 300 265 300 260 260 C 255 220 255 175 265 170 Z"),
        ColorableRegion("uni_muzzle", "Soft Muzzle", "M 265 260 C 275 250 325 250 335 260 C 340 295 260 295 265 260 Z"),
        ColorableRegion("uni_nostril_l", "Left Nostril", "M 285 275 C 282 275 282 280 285 280 C 288 280 288 275 285 275 Z"),
        ColorableRegion("uni_nostril_r", "Right Nostril", "M 315 275 C 312 275 312 280 315 280 C 318 280 318 275 315 275 Z"),
        ColorableRegion("uni_smile", "Gentle Smile", "M 293 285 Q 300 292 307 285 Q 300 287 293 285 Z"),

        // Big Anime Sparkle Eyes
        ColorableRegion("uni_eye_l", "Left Big Eye", "M 275 225 C 275 210 295 210 295 225 C 295 240 275 240 275 225 Z"),
        ColorableRegion("uni_pupil_l", "Left Eye Sparkle", "M 282 220 C 282 215 290 215 290 220 C 290 225 282 225 282 220 Z"),
        ColorableRegion("uni_eye_r", "Right Big Eye", "M 310 225 C 310 210 330 210 330 225 C 330 240 310 240 310 225 Z"),
        ColorableRegion("uni_pupil_r", "Right Eye Sparkle", "M 317 220 C 317 215 325 215 325 220 C 325 225 317 225 317 220 Z"),
        ColorableRegion("uni_blush_l", "Cheek Sparkle Blush Left", "M 265 240 C 265 233 273 233 273 240 C 273 247 265 247 265 240 Z"),
        ColorableRegion("uni_blush_r", "Cheek Sparkle Blush Right", "M 330 240 C 330 233 338 233 338 240 C 338 247 330 247 330 240 Z"),

        // Body & Legs
        ColorableRegion("uni_body", "Unicorn Chubby Body", "M 260 295 C 230 330 230 430 270 450 C 330 460 370 440 350 340 C 345 300 330 290 260 295 Z"),
        ColorableRegion("uni_hoof_front_l", "Front Left Hoof", "M 255 420 L 250 490 L 280 490 L 280 420 Z"),
        ColorableRegion("uni_shoe_fl", "Golden Shoe FL", "M 250 470 L 250 490 L 280 490 L 280 470 Z"),
        ColorableRegion("uni_hoof_front_r", "Front Right Hoof", "M 320 420 L 320 490 L 350 490 L 345 420 Z"),
        ColorableRegion("uni_shoe_fr", "Golden Shoe FR", "M 320 470 L 320 490 L 350 490 L 350 470 Z"),

        // Tail
        ColorableRegion("uni_tail_1", "Fluffy Tail Strand 1", "M 350 410 C 400 400 440 430 420 480 C 390 490 370 460 355 435 Z"),
        ColorableRegion("uni_tail_2", "Fluffy Tail Strand 2", "M 355 435 C 410 440 430 480 395 515 C 370 510 360 480 348 450 Z"),

        // Dreamy Cloud Ground
        ColorableRegion("cloud_ground_center", "Dreamland Cloud Floor", "M 100 520 C 130 470 220 480 250 510 C 290 470 380 470 410 510 C 450 480 520 490 540 530 L 600 600 L 0 600 Z")
    )

    val page2Regions = listOf(
        // Deep Sea Mermaid
        ColorableRegion("sea_bubbles_1", "Bubble Cluster 1", "M 100 120 C 85 120 85 150 100 150 C 115 150 115 120 100 120 Z"),
        ColorableRegion("sea_bubbles_2", "Bubble Cluster 2", "M 130 90 C 120 90 120 110 130 110 C 140 110 140 90 130 90 Z"),
        ColorableRegion("sea_star_hair", "Starfish Hair Accessory", "M 240 140 L 246 155 L 262 156 L 249 168 L 253 184 L 240 174 L 227 184 L 231 168 L 218 156 L 234 155 Z"),

        // Mermaid Hair Flowing
        ColorableRegion("mermaid_hair_main", "Flowing Mermaid Hair", "M 270 140 C 200 120 180 220 170 310 C 160 380 210 430 230 440 C 210 380 220 300 230 250 C 240 180 260 150 270 140 Z"),
        ColorableRegion("mermaid_hair_curl", "Hair Ocean Wave Curl", "M 170 310 C 130 330 120 390 160 410 C 180 390 175 350 170 310 Z"),

        // Face & Body
        ColorableRegion("mermaid_face", "Sweet Mermaid Face", "M 270 160 C 270 120 350 120 350 160 C 350 210 270 210 270 160 Z"),
        ColorableRegion("mm_eye_l", "Mermaid Eye Left", "M 285 165 C 285 155 300 155 300 165 C 300 175 285 175 285 165 Z"),
        ColorableRegion("mm_pupil_l", "Eye Sparkle Left", "M 290 163 C 290 160 295 160 295 163 C 295 166 290 166 290 163 Z"),
        ColorableRegion("mm_eye_r", "Mermaid Eye Right", "M 320 165 C 320 155 335 155 335 165 C 335 175 320 175 320 165 Z"),
        ColorableRegion("mm_pupil_r", "Eye Sparkle Right", "M 325 163 C 325 160 330 160 330 163 C 330 166 325 166 325 163 Z"),
        ColorableRegion("mm_smile", "Mermaid Friendly Smile", "M 305 185 Q 310 192 315 185 Q 310 188 305 185 Z"),

        // Shell Top & Torso
        ColorableRegion("mm_shell_l", "Seashell Top Left", "M 280 215 C 265 210 275 240 295 240 C 305 230 300 215 280 215 Z"),
        ColorableRegion("mm_shell_r", "Seashell Top Right", "M 340 215 C 355 210 345 240 325 240 C 315 230 320 215 340 215 Z"),
        ColorableRegion("mm_torso", "Mermaid Belly", "M 285 240 L 280 280 L 340 280 L 335 240 Z"),

        // Mermaid Tail
        ColorableRegion("mm_tail_belt", "Pearl Waist Belt", "M 275 280 Q 310 290 345 280 Q 310 295 275 280 Z"),
        ColorableRegion("mm_tail_upper", "Tail Upper Scales", "M 280 285 C 260 350 280 400 305 430 C 330 400 350 350 340 285 Z"),
        ColorableRegion("mm_tail_mid", "Tail Fluke Curve", "M 305 430 C 300 460 310 490 310 500 C 325 480 325 450 315 430 Z"),
        ColorableRegion("mm_fin_left", "Fin Swirl Left", "M 310 500 C 260 490 230 550 280 570 C 300 550 305 520 310 500 Z"),
        ColorableRegion("mm_fin_right", "Fin Swirl Right", "M 310 500 C 360 490 390 550 340 570 C 320 550 315 520 310 500 Z"),

        // Playful Little Octopus
        ColorableRegion("octo_head", "Baby Octopus Head", "M 440 280 C 410 280 410 340 440 340 C 470 340 470 280 440 280 Z"),
        ColorableRegion("octo_eye_l", "Octopus Eye L", "M 425 305 C 420 305 420 315 425 315 C 430 315 430 305 425 305 Z"),
        ColorableRegion("octo_eye_r", "Octopus Eye R", "M 445 305 C 440 305 440 315 445 315 C 450 315 450 305 445 305 Z"),
        ColorableRegion("octo_tentacle_1", "Tentacle 1", "M 420 340 C 400 360 410 380 430 365 Z"),
        ColorableRegion("octo_tentacle_2", "Tentacle 2", "M 435 340 C 430 375 455 375 450 340 Z"),
        ColorableRegion("octo_tentacle_3", "Tentacle 3", "M 455 340 C 470 365 485 350 465 340 Z"),

        // Undersea Ocean Floor Coral
        ColorableRegion("coral_branch_l", "Pink Ocean Coral", "M 50 600 L 50 500 C 70 510 80 470 100 480 C 110 520 90 560 120 600 Z"),
        ColorableRegion("coral_branch_r", "Sea Anemone Right", "M 500 600 C 510 540 480 500 520 480 C 550 510 570 550 570 600 Z")
    )

    val page3Regions = listOf(
        // Enchanted Rainbow Castle
        ColorableRegion("castle_sky_cloud_l", "Kingdom Cloud Left", "M 50 100 C 30 80 60 50 100 60 C 120 40 160 50 170 70 C 200 80 190 120 160 130 C 110 130 70 120 50 100 Z"),
        ColorableRegion("castle_sky_cloud_r", "Kingdom Cloud Right", "M 450 90 C 430 70 460 40 500 50 C 520 30 560 40 570 60 C 600 70 590 110 560 120 C 510 120 470 110 450 90 Z"),

        // Rainbow Bridge
        ColorableRegion("bridge_rainbow_top", "Rainbow Bridge Arch 1", "M 100 400 C 100 250 500 250 500 400 L 470 400 C 470 280 130 280 130 400 Z"),
        ColorableRegion("bridge_rainbow_bot", "Rainbow Bridge Arch 2", "M 130 400 C 130 280 470 280 470 400 L 440 400 C 440 310 160 310 160 400 Z"),

        // Towers
        // Left Tower
        ColorableRegion("tower_roof_l", "Left Tower Roof Spire", "M 160 220 L 200 130 L 240 220 Z"),
        ColorableRegion("tower_flag_l", "Left Spire Royal Flag", "M 200 130 L 200 95 L 240 110 L 200 120 Z"),
        ColorableRegion("tower_wall_l", "Left Tower Wall", "M 170 220 L 170 380 L 230 380 L 230 220 Z"),
        ColorableRegion("tower_window_l", "Left Arched Window", "M 190 270 C 190 250 210 250 210 270 L 210 300 L 190 300 Z"),

        // Right Tower
        ColorableRegion("tower_roof_r", "Right Tower Roof Spire", "M 360 220 L 400 130 L 440 220 Z"),
        ColorableRegion("tower_flag_r", "Right Spire Royal Flag", "M 400 130 L 400 95 L 440 110 L 400 120 Z"),
        ColorableRegion("tower_wall_r", "Right Tower Wall", "M 370 220 L 370 380 L 430 380 L 430 220 Z"),
        ColorableRegion("tower_window_r", "Right Arched Window", "M 390 270 C 390 250 410 250 410 270 L 410 300 L 390 300 Z"),

        // Main Center Keep
        ColorableRegion("keep_roof", "Grand Castle Spire", "M 260 170 L 300 70 L 340 170 Z"),
        ColorableRegion("keep_flag", "Crown Grand Flag", "M 300 70 L 300 35 L 345 50 L 300 60 Z"),
        ColorableRegion("keep_wall", "Central Keep Palace", "M 250 170 L 250 380 L 350 380 L 350 170 Z"),
        ColorableRegion("keep_battlement", "Palace Castle Top", "M 240 160 L 240 180 L 360 180 L 360 160 L 345 160 L 345 170 L 330 170 L 330 160 L 315 160 L 315 170 L 285 170 L 285 160 L 270 160 L 270 170 L 255 170 L 255 160 Z"),

        // Castle Gate
        ColorableRegion("castle_gate_arch", "Royal Gate Arch", "M 280 380 C 280 320 320 320 320 380 Z"),
        ColorableRegion("castle_door_l", "Wood Gate Door Left", "M 285 380 L 285 340 C 295 330 300 330 300 340 L 300 380 Z"),
        ColorableRegion("castle_door_r", "Wood Gate Door Right", "M 300 380 L 300 340 C 305 330 310 330 315 340 L 315 380 Z"),

        // Castle Island Mountain
        ColorableRegion("castle_hill", "Fairytale Floating Island", "M 100 380 C 130 360 470 360 500 380 C 530 460 380 540 300 560 C 220 540 70 460 100 380 Z"),
        ColorableRegion("castle_star_1", "Magic Sparkle 1", "M 100 190 L 105 200 L 116 201 L 108 209 L 110 220 L 100 214 L 90 220 L 92 209 L 84 201 L 95 200 Z"),
        ColorableRegion("castle_star_2", "Magic Sparkle 2", "M 500 190 L 505 200 L 516 201 L 508 209 L 510 220 L 500 214 L 490 220 L 492 209 L 484 201 L 495 200 Z")
    )

    return ColoringBook(
        id = "book_unicorns",
        title = "Unicorns, Mermaids, Rainbows & More",
        shortTitle = "Unicorns & Mermaids",
        iconName = "Pets",
        accentColor = Color(0xFFBA55D3),
        pages = listOf(
            ColoringPage("unicorn_page_1", "Starlight Wonder Unicorn", "A playful baby unicorn with spiral horn, mane and rainbow arch", 600f, 600f, page1Regions),
            ColoringPage("unicorn_page_2", "Little Mermaid of the Sea", "Friendly mermaid underwater with sea star, seashells & octopus", 600f, 600f, page2Regions),
            ColoringPage("unicorn_page_3", "Enchanted Rainbow Castle", "Grand fairytale castle with turrets, royal flags & rainbow bridge", 600f, 600f, page3Regions)
        )
    )
}
