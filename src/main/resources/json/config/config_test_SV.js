var configLang = {
	introVideo : 'introFilmerTest/intro.mp4',
	introSound : 'ljudfiler/introUppgift/introUppgift.mp3',
	soundClick : 'ljudfiler/alla-fleraTest/Click1.mp3',
	soundClickStart : 'ljudfiler/alla-fleraTest/Click.mp3',
	tackImage : 'graphics/big_white_roses_200781.jpg',
	tackSistaImage : 'graphics/colorful_rose_bouquet_187931.jpg',
	tackSound : 'ljudfiler/alla-fleraTest/testAvslutat.mp3',
	tackSistaSound : 'ljudfiler/alla-fleraTest/tackForDinMedverkan.mp3',
	tackSoundInterval : 8000,
	tackSistaSoundInterval : 5000,
	introSoundInterval : 4000,

	test1 : {
		soundTest : 'ljudfiler/reaktionstidOvning/choiceTrain.mp3',
		soundTestInterval : 12000,
		soundEndTest : 'ljudfiler/alla-fleraTest/startaTestEllerRepeteraInstruktioner.mp3',
		soundEndInterval : 6000,
		videoTest : 'introFilmerTest/reactionTime.mp4'
	},
	test2 : {
		soundTest : 'ljudfiler/trailMakingTestAoBOvning/trailMakingTestAandBTrain.mp3',
		soundTestInterval : 9000,
		videoTest : 'introFilmerTest/trailMakingTestA.mp4'
	},
	test3 : {
		soundTest : 'ljudfiler/trailMakingTestAoBOvning/trailMakingTestAandBTrain.mp3',
		soundTestInterval : 9000,
		videoTest : 'introFilmerTest/trailMakingTestB.mp4'
	},
	test4 : {
		soundTest : 'ljudfiler/stroopCongruentOvning/stroopCongruentTrain.mp3',
		soundError : 'ljudfiler/stroopCongruent/forTidigt.mp3',
		soundTestInterval : 15000,
		colorErrorSoundInterval : 7000,
		videoTest : 'introFilmerTest/stroopCongruent.mp4'
	},
	test5 : {
		soundTest : 'ljudfiler/stroopIncongruentOvning/stroopIncongruentTrain.mp3',
		soundError : 'ljudfiler/stroopIncongruent/forTidigt.mp3',
		soundTestInterval : 15000,
		betweenButtInterval : 2000,
		colorErrorSoundInterval : 7000,
		videoTest : 'introFilmerTest/stroopIncongruent.mp4',
		colorsSoundErr : {
			red : 'ljudfiler/stroopIncongruentOvning/felTryckRod.mp3',
			green : 'ljudfiler/stroopIncongruentOvning/felTryckGront.mp3',
			yellow : 'ljudfiler/stroopIncongruentOvning/felTryckGul.mp3',
			blue : 'ljudfiler/stroopIncongruentOvning/felTryckBla.mp3'
		}
		},
	test6 : {
		soundTest : 'ljudfiler/minneFordrojd/ordlistaFordrojd.mp3',
		soundError : 'ljudfiler/stroopIncongruent/forTidigt.mp3',
		efterPipsound : 'ljudfiler/minnestest/lasInOrd.mp3',
		pipetSound : 'ljudfiler/alla-fleraTest/pip.mp3',
		sammaOrdIgensound : 'ljudfiler/minnestest/sammaOrdIgen.mp3',
		darefterSound : 'ljudfiler/minnestest/lasForstDarefterKnapp.mp3',
		soundTestInterval : 14000,
		efterPipsoundInterval : 6000,
		pipetSoundInterval : 1000,
		sammaOrdIgensoundInterval : 10000,
		darefterSoundInterval : 5000,
		videoTest : 'introFilmerTest/wordList.mp4',
	},
	test7 : {
		soundTest : 'ljudfiler/minneFordrojd/ordlistaFordrojd.mp3',
		soundError : 'ljudfiler/stroopIncongruent/forTidigt.mp3',
		efterPipsound : 'ljudfiler/minnestest/lasInOrd.mp3',
		pipetSound : 'ljudfiler/alla-fleraTest/pip.mp3',
		darefterSound : 'ljudfiler/minnestest/lasForstDarefterKnapp.mp3',

		darefterSoundInterval : 5000,
		efterPipsoundInterval : 6000,
		pipetSoundInterval : 1000,
		soundTestInterval : 14000,
	},
	test8 : {
		videoTest : 'introFilmerTest/delayedRecognition.mp4'
	},
	test9 : {
		soundTest : 'ljudfiler/fingerTappingOvning/fingerTappingTrain.mp3',
		beginTestSound : 'ljudfiler/fingerTapping/fingerTapping1.mp3',
		endTestSound : 'ljudfiler/fingerTapping/fingerTapping2.mp3',
		pipetSound : 'ljudfiler/alla-fleraTest/pip.mp3',
		soundTestInterval : 18000,
		beginTestSoundInterval : 14000,
		endTestSoundInterval : 15000,
		pipetSoundInterval : 1000,
		videoTest : 'introFilmerTest/fingerTapping.mp4',
		traningDelay : 30000,
		numPadImage : 'graphics/numPad.jpg'
	},
	test10 : {
		soundTest : 'ljudfiler/depperssion/nedstamdhet.mp3',
		nextVideoTest : 'introFilmerTest/reactionTime.mp4',
		soundTestInterval : 8000,
		answers : [ false, true, true, true, false, true, false, true, true, true, false, true, false, true, true ]
	},
	test11 : {
		soundTest : 'ljudfiler/blockDesign/istruktionTraningstest.mp3',
		videoTest : 'introFilmerTest/blockDesign.mp4',
		soundTestInterval : 8000
	},
	test12 : {
		soundTest : {
		A : 'ljudfiler/wordFluency/djur.mp3',
		B : 'ljudfiler/wordFluency/gronsaker.mp3'
		},
		videoTest : 'introFilmerTest/wordFluency.mp4',
		soundTestInterval : 8000
	}
};