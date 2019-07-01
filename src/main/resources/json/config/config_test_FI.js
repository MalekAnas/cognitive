var configLang = {
	introVideo : 'introFilmerTest/FI/CoGNITintroFIN.mp4',
	introSound : 'ljudfiler/FI/intro/intro4.mp3',
	soundClick : 'ljudfiler/alla-fleraTest/Click1.mp3',
	soundClickStart : 'ljudfiler/alla-fleraTest/Click.mp3',
	tackImage : 'graphics/big_white_roses_200781.jpg',
	tackSistaImage : 'graphics/colorful_rose_bouquet_187931.jpg',
	tackSound : 'ljudfiler/FI/general/cognit1.mp3',
	tackSistaSound : 'ljudfiler/FI/general/cognit3.mp3',
	tackSoundInterval : 8000,
	tackSistaSoundInterval : 6000,
	introSoundInterval : 4000,

	test1 : {
		soundTest : 'ljudfiler/FI/reaction/reactTime789.mp3',
		soundTestInterval : 16000,
		soundEndTest : 'ljudfiler/FI/general/cognit2.mp3',
		soundEndInterval : 8000,
		videoTest : 'introFilmerTest/FI/CoGNITchoiceFIN.mp4'
	},
	test2 : {
		soundTest : 'ljudfiler/FI/trailA/trailA5.mp3',
		soundTestInterval : 10000,
		videoTest : 'introFilmerTest/FI/CoGNIThandTmtAFIN.mp4'
	},
	test3 : {
		soundTest : 'ljudfiler/FI/trailA/trailA5.mp3',
		soundTestInterval : 10000,
		videoTest : 'introFilmerTest/FI/CoGNIThandTmtB_FIN.mp4'
	},
	test4 : {
		soundTest : 'ljudfiler/FI/stroopCong/stroop5.mp3',
		soundError : 'ljudfiler/FI/reaction/reactionTime9.mp3',
		soundTestInterval : 15000,
		colorErrorSoundInterval : 7000,
		videoTest : 'introFilmerTest/FI/CoGNITpreStroopFIN.mp4'
	},
	test5 : {
		soundTest : 'ljudfiler/FI/stroopIncong/stroopInterf5.mp3',
		soundError : 'ljudfiler/FI/reaction/reactionTime9.mp3',
		soundTestInterval : 15000,
		betweenButtInterval : 2000,
		colorErrorSoundInterval : 7000,
		videoTest : 'introFilmerTest/FI/CoGNIThandStroopFIN.mp4',
		colorsSoundErr : {
			red : 'ljudfiler/FI/stroopIncong/stroopInterf8.mp3',
			green : 'ljudfiler/FI/stroopIncong/stroopInterf7.mp3',
			yellow : 'ljudfiler/FI/stroopIncong/stroopInterf9.mp3',
			blue : 'ljudfiler/FI/stroopIncong/stroopInterf6.mp3'
		}
		},
	test6 : {
		soundTest : 'ljudfiler/FI/delayedRec/delayRecall.mp3',
		soundError : 'ljudfiler/FI/reaction/reactionTime9.mp3',
		efterPipsound : 'ljudfiler/FI/word/wlist7.mp3',
		pipetSound : 'ljudfiler/alla-fleraTest/pip.mp3',
		sammaOrdIgensound : 'ljudfiler/FI/word/wlist9.mp3',
		darefterSound : 'ljudfiler/FI/word/wlist8.mp3',
		soundTestInterval : 14000,
		efterPipsoundInterval : 7000,
		pipetSoundInterval : 1000,
		sammaOrdIgensoundInterval : 9000,
		darefterSoundInterval : 6000,
		videoTest : 'introFilmerTest/FI/CoGNIThandWordlistFIN.mp4',
	},
	test7 : {
		soundTest : 'ljudfiler/FI/delayedRec/delayRecall.mp3',
		soundError : 'ljudfiler/FI/reaction/reactionTime9.mp3',
		efterPipsound : 'ljudfiler/FI/word/wlist7.mp3',
		pipetSound : 'ljudfiler/alla-fleraTest/pip.mp3',
		darefterSound : 'ljudfiler/FI/word/wlist8.mp3',

		darefterSoundInterval : 5000,
		efterPipsoundInterval : 7000,
		pipetSoundInterval : 1000,
		soundTestInterval : 14000,
	},
	test8 : {
		videoTest : 'introFilmerTest/FI/CoGNIThandDelayedRecognitionFIN.mp4'
	},
	test9 : {
		soundTest : 'ljudfiler/FI/fingertap/fingertap10.mp3',
		beginTestSound : 'ljudfiler/FI/fingertap/fingertap11.mp3',
		endTestSound : 'ljudfiler/FI/fingertap/fingertap12.mp3',
		pipetSound : 'ljudfiler/alla-fleraTest/pip.mp3',
		soundTestInterval : 10000,
		beginTestSoundInterval : 17000,
		endTestSoundInterval : 19000,
		pipetSoundInterval : 1000,
		videoTest : 'introFilmerTest/FI/CoGNIThandFingerTapNewFIN.mp4',
		traningDelay : 30000,
		numPadImage : 'graphics/numPad.jpg'
	},
	test10 : {
		soundTest : 'ljudfiler/FI/depression/GDSintroFIN.mp3',
		nextVideoTest : 'introFilmerTest/FI/CoGNITchoiceFIN.mp4',
		soundTestInterval : 8000,
		answers : [ false, true, true, true, false, true, false, true, true, true, false, true, false, true, true ]
	}
};