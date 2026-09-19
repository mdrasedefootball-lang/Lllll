package com.example.data.books

import androidx.compose.ui.graphics.Color
import com.example.data.models.ColorableRegion
import com.example.data.models.ColoringBook
import com.example.data.models.ColoringPage

fun getBook1Fairies(): ColoringBook {
    val page1Regions = listOf(
        // Background sky elements
        ColorableRegion("cloud_1", "Fluffy Cloud", "M 60 90 C 60 70 80 50 110 55 C 130 40 160 45 175 65 C 195 65 210 80 205 105 C 205 125 185 135 155 135 C 125 135 110 135 90 130 C 65 125 60 110 60 90 Z"),
        ColorableRegion("cloud_2", "Little Cloud", "M 420 100 C 420 85 435 70 455 75 C 470 60 495 65 505 80 C 520 80 535 95 530 115 C 530 130 515 140 490 140 C 460 140 445 140 435 130 C 420 125 420 110 420 100 Z"),
        ColorableRegion("star_1", "Magic Sparkle Star", "M 130 180 L 140 200 L 162 203 L 146 218 L 150 240 L 130 229 L 110 240 L 114 218 L 98 203 L 120 200 Z"),
        ColorableRegion("star_2", "Twinkle Star", "M 480 180 L 488 196 L 506 198 L 493 211 L 496 228 L 480 220 L 464 228 L 467 211 L 454 198 L 472 196 Z"),
        ColorableRegion("star_3", "Tiny Star", "M 380 90 L 385 102 L 398 103 L 388 112 L 391 125 L 380 119 L 369 125 L 372 112 L 362 103 L 375 102 Z"),

        // Fairy Wings
        ColorableRegion("wing_l_top", "Left Upper Wing", "M 250 250 C 170 210 100 230 110 310 C 115 360 180 370 245 315 Z"),
        ColorableRegion("wing_l_bottom", "Left Lower Wing", "M 240 320 C 180 340 140 410 180 445 C 215 470 250 410 245 350 Z"),
        ColorableRegion("wing_r_top", "Right Upper Wing", "M 350 250 C 430 210 500 230 490 310 C 485 360 420 370 355 315 Z"),
        ColorableRegion("wing_r_bottom", "Right Lower Wing", "M 360 320 C 420 340 460 410 420 445 C 385 470 350 410 355 350 Z"),
        ColorableRegion("wing_l_spot", "Left Wing Jewel", "M 160 300 C 160 280 185 280 185 300 C 185 320 160 320 160 300 Z"),
        ColorableRegion("wing_r_spot", "Right Wing Jewel", "M 415 300 C 415 280 440 280 440 300 C 440 320 415 320 415 300 Z"),

        // Fairy Hair Back & Bun
        ColorableRegion("hair_bun", "Fairy Hair Bun", "M 260 145 C 260 90 340 90 340 145 C 340 170 260 170 260 145 Z"),
        ColorableRegion("hair_back", "Fairy Flowing Hair", "M 240 230 C 200 260 200 340 235 370 C 245 320 250 280 250 260 Z"),

        // Fairy Head & Face
        ColorableRegion("face", "Fairy Face", "M 255 215 C 250 270 270 305 300 305 C 330 305 350 270 345 215 C 345 175 255 175 255 215 Z"),
        ColorableRegion("hair_bangs", "Fairy Bangs", "M 250 210 C 270 230 290 220 300 225 C 315 220 335 230 350 210 C 345 170 255 170 250 210 Z"),
        ColorableRegion("crown", "Flower Crown Band", "M 252 185 Q 300 175 348 185 Q 300 195 252 185 Z"),
        ColorableRegion("crown_flower_1", "Crown Blossom Left", "M 265 175 C 255 165 275 155 280 170 C 285 155 300 165 290 175 C 300 185 285 195 280 180 C 275 195 255 185 265 175 Z"),
        ColorableRegion("crown_flower_center", "Crown Big Blossom", "M 300 165 C 290 150 310 140 315 155 C 325 140 340 150 330 165 C 340 178 325 190 315 175 C 310 190 290 178 300 165 Z"),

        // Face Features
        ColorableRegion("eye_l", "Left Eye", "M 270 245 C 270 235 285 235 285 245 C 285 255 270 255 270 245 Z"),
        ColorableRegion("pupil_l", "Left Pupil Highlight", "M 275 243 C 275 240 280 240 280 243 C 280 246 275 246 275 243 Z"),
        ColorableRegion("eye_r", "Right Eye", "M 315 245 C 315 235 330 235 330 245 C 330 255 315 255 315 245 Z"),
        ColorableRegion("pupil_r", "Right Pupil Highlight", "M 320 243 C 320 240 325 240 325 243 C 325 246 320 246 320 243 Z"),
        ColorableRegion("blush_l", "Left Cheek Blush", "M 262 260 C 262 255 272 255 272 260 C 272 265 262 265 262 260 Z"),
        ColorableRegion("blush_r", "Right Cheek Blush", "M 328 260 C 328 255 338 255 338 260 C 338 265 328 265 328 260 Z"),
        ColorableRegion("smile", "Cute Smile", "M 292 270 Q 300 280 308 270 Q 300 274 292 270 Z"),

        // Clothes & Body
        ColorableRegion("dress_top", "Fairy Top", "M 280 300 L 270 340 L 330 340 L 320 300 Z"),
        ColorableRegion("dress_belt", "Magic Sash", "M 268 340 L 265 352 L 335 352 L 332 340 Z"),
        ColorableRegion("dress_skirt", "Petal Skirt", "M 265 352 C 240 400 260 430 275 435 C 290 415 300 425 300 425 C 300 425 310 415 325 435 C 340 430 360 400 335 352 Z"),
        ColorableRegion("arm_l", "Left Arm", "M 275 305 C 255 320 240 340 235 365 C 243 368 255 350 272 325 Z"),
        ColorableRegion("arm_r", "Right Arm Wand Arm", "M 325 305 C 345 320 360 335 375 340 C 378 333 365 315 332 300 Z"),

        // Wand
        ColorableRegion("wand_shaft", "Magic Wand Shaft", "M 370 340 L 415 285 L 420 290 L 375 345 Z"),
        ColorableRegion("wand_star", "Wand Star Gem", "M 425 270 L 432 284 L 448 285 L 436 296 L 439 311 L 425 303 L 411 311 L 414 296 L 402 285 L 418 284 Z"),

        // Legs & Shoes
        ColorableRegion("leg_l", "Left Leg", "M 283 430 L 283 480 L 293 480 L 293 430 Z"),
        ColorableRegion("leg_r", "Right Leg", "M 307 430 L 307 480 L 317 480 L 317 430 Z"),
        ColorableRegion("shoe_l", "Left Fairy Shoe", "M 278 480 C 275 500 300 500 298 480 Z"),
        ColorableRegion("shoe_r", "Right Fairy Shoe", "M 302 480 C 299 500 324 500 322 480 Z"),

        // Forest ground & mushrooms & snail
        ColorableRegion("ground_hill", "Grassy Hill", "M 0 510 Q 300 460 600 510 L 600 600 L 0 600 Z"),
        ColorableRegion("mushroom_cap", "Big Toadstool Cap", "M 80 470 C 80 400 180 400 180 470 Z"),
        ColorableRegion("mushroom_spot_1", "Mushroom Spot 1", "M 110 435 C 110 420 130 420 130 435 C 130 450 110 450 110 435 Z"),
        ColorableRegion("mushroom_spot_2", "Mushroom Spot 2", "M 145 445 C 145 435 160 435 160 445 C 160 455 145 455 145 445 Z"),
        ColorableRegion("mushroom_stem", "Mushroom Stem", "M 115 470 L 110 540 L 150 540 L 145 470 Z"),

        ColorableRegion("snail_shell", "Cute Snail Swirl Shell", "M 460 480 C 430 480 430 530 460 530 C 490 530 490 480 460 480 Z"),
        ColorableRegion("snail_body", "Snail Friendly Body", "M 440 535 C 470 535 520 535 520 515 C 520 500 505 500 495 515 C 470 520 440 525 430 535 Z"),
        ColorableRegion("snail_eye", "Snail Little Eye", "M 510 495 C 505 495 505 505 510 505 C 515 505 515 495 510 495 Z"),

        ColorableRegion("flower_forest", "Forest Bloom Petals", "M 530 440 C 515 425 545 410 550 430 C 565 415 580 435 570 445 C 585 455 570 475 555 460 C 545 475 525 460 530 440 Z"),
        ColorableRegion("flower_forest_center", "Forest Bloom Core", "M 545 440 C 545 433 555 433 555 440 C 555 447 545 447 545 440 Z")
    )

    val page2Regions = listOf(
        // Butterfly Garden Scene
        ColorableRegion("sun_garden", "Happy Smiling Sun", "M 50 50 C 10 50 10 110 50 110 C 90 110 90 50 50 50 Z"),
        ColorableRegion("sun_ray_1", "Sun Beam 1", "M 90 70 L 120 60 L 95 85 Z"),
        ColorableRegion("sun_ray_2", "Sun Beam 2", "M 65 115 L 85 140 L 50 125 Z"),
        ColorableRegion("cloud_garden", "Garden Breeze Cloud", "M 430 70 C 430 50 460 40 480 55 C 500 45 530 55 535 75 C 555 85 550 110 530 115 C 500 120 450 120 430 100 Z"),

        // Central Butterfly - Wings
        ColorableRegion("bf_wing_top_l", "Wing Top Left Main", "M 270 240 C 180 120 80 160 100 270 C 110 330 190 350 260 290 Z"),
        ColorableRegion("bf_wing_spot_tl1", "Wing TL Big Circle", "M 140 230 C 140 200 180 200 180 230 C 180 260 140 260 140 230 Z"),
        ColorableRegion("bf_wing_spot_tl2", "Wing TL Heart Gem", "M 195 240 C 190 220 220 220 220 240 C 220 260 195 270 195 240 Z"),

        ColorableRegion("bf_wing_bot_l", "Wing Bottom Left Main", "M 260 300 C 170 330 140 430 200 460 C 250 480 280 400 270 340 Z"),
        ColorableRegion("bf_wing_spot_bl", "Wing BL Teardrop", "M 200 390 C 180 370 220 350 230 380 C 240 410 200 420 200 390 Z"),

        ColorableRegion("bf_wing_top_r", "Wing Top Right Main", "M 330 240 C 420 120 520 160 500 270 C 490 330 410 350 340 290 Z"),
        ColorableRegion("bf_wing_spot_tr1", "Wing TR Big Circle", "M 420 230 C 420 200 460 200 460 230 C 460 260 420 260 420 230 Z"),
        ColorableRegion("bf_wing_spot_tr2", "Wing TR Heart Gem", "M 380 240 C 380 220 410 220 405 240 C 405 270 380 260 380 240 Z"),

        ColorableRegion("bf_wing_bot_r", "Wing Bottom Right Main", "M 340 300 C 430 330 460 430 400 460 C 350 480 320 400 330 340 Z"),
        ColorableRegion("bf_wing_spot_br", "Wing BR Teardrop", "M 370 390 C 360 350 400 370 400 390 C 400 420 360 410 370 390 Z"),

        // Butterfly Head & Body
        ColorableRegion("bf_antenna_l", "Left Swirl Antenna", "M 285 190 Q 250 140 230 150 Q 250 170 285 195 Z"),
        ColorableRegion("bf_antenna_r", "Right Swirl Antenna", "M 315 190 Q 350 140 370 150 Q 350 170 315 195 Z"),
        ColorableRegion("bf_head", "Butterfly Face", "M 275 195 C 275 170 325 170 325 195 C 325 220 275 220 275 195 Z"),
        ColorableRegion("bf_eye_l", "Left Sparkle Eye", "M 285 195 C 285 188 295 188 295 195 C 295 202 285 202 285 195 Z"),
        ColorableRegion("bf_eye_r", "Right Sparkle Eye", "M 305 195 C 305 188 315 188 315 195 C 315 202 305 202 305 195 Z"),
        ColorableRegion("bf_body_seg1", "Body Segment 1", "M 280 225 C 280 215 320 215 320 225 C 320 250 280 250 280 225 Z"),
        ColorableRegion("bf_body_seg2", "Body Segment 2", "M 282 255 C 282 245 318 245 318 255 C 318 285 282 285 282 255 Z"),
        ColorableRegion("bf_body_seg3", "Body Segment 3", "M 285 290 C 285 280 315 280 315 290 C 315 325 285 325 285 290 Z"),
        ColorableRegion("bf_body_seg4", "Body Segment 4", "M 288 330 C 288 320 312 320 312 330 C 312 375 288 375 288 330 Z"),

        // Giant Garden Flowers
        ColorableRegion("flower_center_sun", "Sunflower Heart", "M 480 470 C 450 470 450 530 480 530 C 510 530 510 470 480 470 Z"),
        ColorableRegion("sunflower_petal_1", "Petal North", "M 470 470 C 460 435 500 435 490 470 Z"),
        ColorableRegion("sunflower_petal_2", "Petal East", "M 505 485 C 540 475 540 515 505 505 Z"),
        ColorableRegion("sunflower_petal_3", "Petal South", "M 470 530 C 460 565 500 565 490 530 Z"),
        ColorableRegion("sunflower_petal_4", "Petal West", "M 455 485 C 420 475 420 515 455 505 Z"),
        ColorableRegion("sunflower_leaf", "Sunflower Leaf", "M 450 550 C 400 540 410 585 460 575 Z"),

        ColorableRegion("tulip_head", "Happy Red Tulip", "M 100 480 C 80 440 100 430 110 450 C 120 430 140 440 120 480 Z"),
        ColorableRegion("tulip_stem", "Tulip Green Stem", "M 107 480 L 105 560 L 115 560 L 113 480 Z"),

        // Friendly Ladybug
        ColorableRegion("ladybug_shell", "Ladybug Red Shell", "M 210 530 C 210 500 260 500 260 530 Z"),
        ColorableRegion("ladybug_head", "Ladybug Cute Face", "M 255 520 C 265 515 275 535 260 535 Z"),
        ColorableRegion("ladybug_spot1", "Ladybug Spot 1", "M 225 515 C 220 515 220 525 225 525 C 230 525 230 515 225 515 Z"),
        ColorableRegion("ladybug_spot2", "Ladybug Spot 2", "M 245 520 C 240 520 240 528 245 528 C 250 528 250 520 245 520 Z")
    )

    val page3Regions = listOf(
        // Forest Friends Picnic
        ColorableRegion("tree_leaves_left", "Forest Canopy Left", "M 0 0 L 0 200 C 50 180 120 220 150 170 C 180 120 120 50 80 0 Z"),
        ColorableRegion("tree_leaves_right", "Forest Canopy Right", "M 600 0 L 600 200 C 550 180 480 220 450 170 C 420 120 480 50 520 0 Z"),

        // Cute Bunny
        ColorableRegion("ear_outer_l", "Bunny Left Ear Outer", "M 260 210 C 230 110 200 120 245 200 Z"),
        ColorableRegion("ear_inner_l", "Bunny Left Ear Pink", "M 255 195 C 240 135 220 140 248 190 Z"),
        ColorableRegion("ear_outer_r", "Bunny Right Ear Outer", "M 340 210 C 370 110 400 120 355 200 Z"),
        ColorableRegion("ear_inner_r", "Bunny Right Ear Pink", "M 345 195 C 360 135 380 140 352 190 Z"),

        ColorableRegion("bunny_head", "Bunny Fluffy Head", "M 240 250 C 230 190 370 190 360 250 C 375 280 370 310 300 310 C 230 310 225 280 240 250 Z"),
        ColorableRegion("bunny_eye_l", "Bunny Big Left Eye", "M 265 245 C 265 235 280 235 280 245 C 280 255 265 255 265 245 Z"),
        ColorableRegion("bunny_pupil_l", "Bunny Left Shine", "M 270 242 C 270 239 275 239 275 242 C 275 245 270 245 270 242 Z"),
        ColorableRegion("bunny_eye_r", "Bunny Big Right Eye", "M 320 245 C 320 235 335 235 335 245 C 335 255 320 255 320 245 Z"),
        ColorableRegion("bunny_pupil_r", "Bunny Right Shine", "M 325 242 C 325 239 330 239 330 242 C 330 245 325 245 325 242 Z"),
        ColorableRegion("bunny_nose", "Bunny Cute Heart Nose", "M 295 260 L 305 260 L 300 268 Z"),
        ColorableRegion("bunny_cheeks", "Bunny Rosy Cheek Left", "M 250 265 C 245 265 245 275 250 275 C 255 275 255 265 250 265 Z"),
        ColorableRegion("bunny_cheeks_r", "Bunny Rosy Cheek Right", "M 350 265 C 345 265 345 275 350 275 C 355 275 355 265 350 265 Z"),

        // Bunny Clothing
        ColorableRegion("bunny_sweater", "Cozy Knit Sweater", "M 260 305 L 240 380 L 360 380 L 340 305 Z"),
        ColorableRegion("bunny_pocket", "Sweater Heart Pocket", "M 290 335 C 285 325 300 320 300 330 C 300 320 315 325 310 335 L 300 350 Z"),
        ColorableRegion("bunny_sleeve_l", "Sweater Sleeve Left", "M 260 310 L 230 350 L 245 360 L 268 325 Z"),
        ColorableRegion("bunny_sleeve_r", "Sweater Sleeve Right", "M 340 310 L 370 350 L 355 360 L 332 325 Z"),
        ColorableRegion("bunny_paw_l", "Left Little Paw", "M 225 350 C 220 365 240 370 245 358 Z"),
        ColorableRegion("bunny_paw_r", "Right Little Paw", "M 375 350 C 380 365 360 370 355 358 Z"),
        ColorableRegion("bunny_foot_l", "Left Bunny Foot", "M 245 380 C 230 410 280 415 280 380 Z"),
        ColorableRegion("bunny_foot_r", "Right Bunny Foot", "M 320 380 C 320 415 370 410 355 380 Z"),

        // Picnic Basket & Goodies
        ColorableRegion("basket_body", "Woven Picnic Basket", "M 390 370 L 410 440 L 490 440 L 510 370 Z"),
        ColorableRegion("basket_lid", "Picnic Basket Lid", "M 380 360 L 520 360 L 510 375 L 390 375 Z"),
        ColorableRegion("basket_bow", "Basket Ribbon Bow", "M 440 350 C 430 340 450 330 450 350 C 450 330 470 340 460 350 Z"),
        ColorableRegion("apple_red", "Shiny Picnic Apple", "M 420 340 C 410 315 440 315 440 330 C 440 315 470 315 460 340 C 455 360 425 360 420 340 Z"),
        ColorableRegion("apple_leaf", "Apple Green Leaf", "M 440 318 C 450 305 460 315 442 322 Z"),

        // Little Songbird
        ColorableRegion("bird_body", "Little Forest Songbird", "M 140 350 C 110 360 120 410 150 410 C 180 410 190 365 160 350 Z"),
        ColorableRegion("bird_wing", "Songbird Wing", "M 135 375 C 115 385 140 405 155 390 Z"),
        ColorableRegion("bird_beak", "Songbird Yellow Beak", "M 175 365 L 195 370 L 175 375 Z"),
        ColorableRegion("bird_eye", "Songbird Eye", "M 165 363 C 162 363 162 367 165 367 C 168 367 168 363 165 363 Z"),

        ColorableRegion("meadow_ground", "Picnic Blanket Grass", "M 0 450 Q 300 420 600 450 L 600 600 L 0 600 Z")
    )

    return ColoringBook(
        id = "book_fairies",
        title = "Fairies, Animals, Butterflies & More",
        shortTitle = "Fairies & Friends",
        iconName = "AutoAwesome",
        accentColor = Color(0xFFFF69B4),
        pages = listOf(
            ColoringPage("fairy_page_1", "Magical Woodland Fairy", "A cute fairytale fairy with wand, wings & forest treasures", 600f, 600f, page1Regions),
            ColoringPage("fairy_page_2", "Butterfly Garden Adventure", "Big friendly cartoon butterfly surrounded by blooming flowers", 600f, 600f, page2Regions),
            ColoringPage("fairy_page_3", "Forest Friends Picnic", "Adorable woodland bunny with cozy sweater and fruit basket", 600f, 600f, page3Regions)
        )
    )
}
