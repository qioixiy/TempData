package com.xxx.utils;

public class algorithm {
	public enum FINGER_TYPE {
		Wt, Ws, We, Wc, Wd, Wi, Wp, Rp, Wl, Rl, U, R, Lf, Rf, As, Ae, At, Au, Ar, Wx, Ux, Ax,
	}

	public class algorithmInput {
		public class FingerData {
			public float RcBig;
			public float RcSmall;
			public FINGER_TYPE mFINGER_TYPE;

			public FingerData() {
				RcBig = RcSmall = 0.0f;
				mFINGER_TYPE = FINGER_TYPE.Wt;
			}
		}

		// finger data left and right, size = 5
		public FingerData mFingerDataLeft[];
		public FingerData mFingerDataRight[];

		public algorithmInput() {
			mFingerDataLeft = new FingerData[5];
			mFingerDataLeft[0] = new FingerData();
			mFingerDataLeft[1] = new FingerData();
			mFingerDataLeft[2] = new FingerData();
			mFingerDataLeft[3] = new FingerData();
			mFingerDataLeft[4] = new FingerData();
			mFingerDataRight = new FingerData[5];
			mFingerDataRight[0] = new FingerData();
			mFingerDataRight[1] = new FingerData();
			mFingerDataRight[2] = new FingerData();
			mFingerDataRight[3] = new FingerData();
			mFingerDataRight[4] = new FingerData();
		}
	}

	public class algorithmOutput {
		float LeftBrain;// ×óÄÔ
		float RightBrain;// ÓÒÄÔ
		float reason1;// ÀíÐÔ
		float reason2;
		float reason3;
		float reason4;
		float reason5;
		float Sensibility1;// ¸ÐÐÔ
		float Sensibility2;
		float Sensibility3;
		float Sensibility4;
		float Sensibility5;
		float motivation;// ¶¯»ú
		float Idea;// ¹¹Ë¼
		float Visual;// ÊÓ¾õ
		float AuditorySense;// Ìý¾õ
		float Somatosensory;// Ìå¾õ
	}

	public algorithm() {
		;
	}

	public float GetTnWithFINGER_TYPE(FINGER_TYPE type, int index) {
		/*
		 * tn Wt:WsLn[We¡¢Wc¡¢Wd¡¢Wi¡¢Wx Wl¡¢Rl¡¢Wp¡¢Rp U¡¢R¡¢Lf¡¢Rf¡¢Ux As¡¢Ae¡¢At¡¢Au¡¢Ar¡¢Ax
		 * ¶ÔÈË --> Ä´Ö¸ t1 1 0.13333 0.14285 1.04657 ¶ÔÊÂ --> Ê³Ö¸ t2 1 0.14285 0.15384
		 * 1.04657 ¶ÔÖ«Ìå --> ÖÐÖ¸ t3 1 0.15384 0.16667 1.04657 ¶ÔÉùÒô --> »·Ö¸ t4 1
		 * 0.16667 0.18182 1.04657 ¶ÔÍ¼Ïñ --> Î²Ö¸ t5 1 0.18182 0.19990 1.04657
		 */

		float ret = 0f;
		switch (index) {
		case 1:
			switch (type) {
			case Wt:
			case Ws:
			case We:
			case Wc:
			case Wd:
			case Wi:
			case Wx:
				ret = 1;
				break;
			case Wl:
			case Rl:
			case Wp:
			case Rp:
				ret = 0.13333f;
				break;
			case U:
			case R:
			case Lf:
			case Rf:
			case Ux:
				ret = 0.14285f;
				break;
			case As:
			case Ae:
			case At:
			case Au:
			case Ar:
			case Ax:
				ret = 1.04657f;
				break;
			default:
				System.out.println("invalid FINGER_TYPE " + type);
			}
			break;
		case 2:
			switch (type) {
			case Wt:
			case Ws:
			case We:
			case Wc:
			case Wd:
			case Wi:
			case Wx:
				ret = 1;
				break;
			case Wl:
			case Rl:
			case Wp:
			case Rp:
				ret = 0.14285f;
				break;
			case U:
			case R:
			case Lf:
			case Rf:
			case Ux:
				ret = 0.15384f;
				break;
			case As:
			case Ae:
			case At:
			case Au:
			case Ar:
			case Ax:
				ret = 1.04657f;
				break;
			default:
				System.out.println("invalid FINGER_TYPE " + type);
			}
			break;
		case 3:
			switch (type) {
			case Wt:
			case Ws:
			case We:
			case Wc:
			case Wd:
			case Wi:
			case Wx:
				ret = 1;
				break;
			case Wl:
			case Rl:
			case Wp:
			case Rp:
				ret = 0.15384f;
				break;
			case U:
			case R:
			case Lf:
			case Rf:
			case Ux:
				ret = 0.16667f;
				break;
			case As:
			case Ae:
			case At:
			case Au:
			case Ar:
			case Ax:
				ret = 1.04657f;
				break;
			default:
				System.out.println("invalid FINGER_TYPE " + type);
			}
			break;
		case 4:
			switch (type) {
			case Wt:
			case Ws:
			case We:
			case Wc:
			case Wd:
			case Wi:
			case Wx:
				ret = 1;
				break;
			case Wl:
			case Rl:
			case Wp:
			case Rp:
				ret = 0.16667f;
				break;
			case U:
			case R:
			case Lf:
			case Rf:
			case Ux:
				ret = 0.18182f;
				break;
			case As:
			case Ae:
			case At:
			case Au:
			case Ar:
			case Ax:
				ret = 1.04657f;
				break;
			default:
				System.out.println("invalid FINGER_TYPE " + type);
			}
			break;
		case 5:
			switch (type) {
			case Wt:
			case Ws:
			case We:
			case Wc:
			case Wd:
			case Wi:
			case Wx:
				ret = 1;
				break;
			case Wl:
			case Rl:
			case Wp:
			case Rp:
				ret = 0.18182f;
				break;
			case U:
			case R:
			case Lf:
			case Rf:
			case Ux:
				ret = 0.19990f;
				break;
			case As:
			case Ae:
			case At:
			case Au:
			case Ar:
			case Ax:
				ret = 1.04657f;
				break;
			default:
				System.out.println("invalid FINGER_TYPE " + type);
			}
			break;
		default:
			System.out.println("invalid index " + index);
		}
		return ret;
	}

	public algorithmOutput Run(algorithmInput input) {
		algorithmOutput retOut = new algorithmOutput();
		/*
		 * Amn=tn*Rc´ó*Rc´ó m=×ó|ÓÒ£¬n=1,2,3,4,5 ÎÆÐÍ£ºWl¡¢Rl¡¢Wp¡¢Rp¡¢U¡¢R¡¢Lf¡¢Rf¡¢Ux
		 * Amn=Rc×ó+RcÓÒ m=×ó|ÓÒ£¬n=1,2,3,4,5
		 * ÎÆÐÍ£ºWt¡¢Ws¡¢We¡¢Wc¡¢Wd¡¢Wi¡¢As¡¢Ae¡¢At¡¢Au¡¢Ar¡¢Wx¡¢Ax
		 */

		// left
		float ALn[] = new float[6];
		for (int i = 1; i < 6; i++) {
			FINGER_TYPE mFINGER_TYPE = input.mFingerDataLeft[i - 1].mFINGER_TYPE;
			int index = i;

			float tn = GetTnWithFINGER_TYPE(mFINGER_TYPE, index);

			switch (mFINGER_TYPE) {
			case Wl:
			case Rl:
			case Wp:
			case Rp:
			case U:
			case R:
			case Lf:
			case Rf:
			case Ux:
				ALn[i] = tn * input.mFingerDataLeft[i - 1].RcBig * input.mFingerDataLeft[i - 1].RcSmall;
				break;
			case Wt:
			case Ws:
			case We:
			case Wc:
			case Wd:
			case Wi:
			case As:
			case Ae:
			case At:
			case Au:
			case Ar:
			case Wx:
			case Ax:
				ALn[i] = input.mFingerDataLeft[i - 1].RcBig + input.mFingerDataLeft[i - 1].RcSmall;
				break;
			default:
				System.out.println("invalid FINGER_TYPE " + mFINGER_TYPE);
				break;
			}
		}

		// right
		float ARn[] = new float[6];
		for (int i = 1; i < 6; i++) {
			FINGER_TYPE mFINGER_TYPE = input.mFingerDataRight[i - 1].mFINGER_TYPE;
			int index = i;

			float tn = GetTnWithFINGER_TYPE(mFINGER_TYPE, index);

			switch (mFINGER_TYPE) {
			case Wl:
			case Rl:
			case Wp:
			case Rp:
			case U:
			case R:
			case Lf:
			case Rf:
			case Ux:
				ARn[i] = tn * input.mFingerDataRight[i - 1].RcBig * input.mFingerDataRight[i - 1].RcSmall;
				break;
			case Wt:
			case Ws:
			case We:
			case Wc:
			case Wd:
			case Wi:
			case As:
			case Ae:
			case At:
			case Au:
			case Ar:
			case Wx:
			case Ax:
				ARn[i] = input.mFingerDataRight[i - 1].RcBig + input.mFingerDataRight[i - 1].RcSmall;
				break;
			default:
				System.out.println("invalid FINGER_TYPE " + mFINGER_TYPE);
				break;
			}
		}
		/*
		 * ×óÄÔ
		 * 100*(AÓÒ1+AÓÒ2+AÓÒ3+AÓÒ4+AÓÒ5)/(A×ó1+A×ó2+A×ó3+A×ó4+A×ó5+AÓÒ1+AÓÒ2+AÓÒ3+AÓÒ4+AÓÒ5)
		 * ÓÒÄÔ
		 * 100*(A×ó1+A×ó2+A×ó3+A×ó4+A×ó5)/(A×ó1+A×ó2+A×ó3+A×ó4+A×ó5+AÓÒ1+AÓÒ2+AÓÒ3+AÓÒ4+AÓÒ5)
		 * ÀíÐÔ 100*AÓÒn/(A×ón+AÓÒn£© ¼Ó% ¸ÐÐÔ 100*A×ón/(A×ón+AÓÒn£© ¼Ó% ¶¯»ú
		 * 100*(A×ó1+AÓÒ1)/(A×ó1+AÓÒ1+A×ó2+AÓÒ2) ¼Ó% ¹¹Ë¼ 100*(A×ó2+AÓÒ2)/(A×ó1+AÓÒ1+A×ó2+AÓÒ2)
		 * ¼Ó% ÊÓ¾õ 100*(A×ó5+AÓÒ5)/(A×ó3+AÓÒ3+A×ó4+AÓÒ4+A×ó5+AÓÒ5) ¼Ó% Ìý¾õ
		 * 100*(A×ó4+AÓÒ4)/(A×ó3+AÓÒ3+A×ó4+AÓÒ4+A×ó5+AÓÒ5) ¼Ó% Ìå¾õ
		 * 100*(A×ó3+AÓÒ3)/(A×ó3+AÓÒ3+A×ó4+AÓÒ4+A×ó5+AÓÒ5) ¼Ó% //
		 */

		retOut.LeftBrain = 100 * (ARn[1] + ARn[2] + ARn[3] + ARn[4] + ARn[5])
				/ (ALn[1] + ALn[2] + ALn[3] + ALn[4] + ALn[5] + ARn[1] + ARn[2] + ARn[3] + ARn[4] + ARn[5]);
		retOut.RightBrain = 100 * (ALn[1] + ALn[2] + ALn[3] + ALn[4] + ALn[5])
				/ (ALn[1] + ALn[2] + ALn[3] + ALn[4] + ALn[5] + ARn[1] + ARn[2] + ARn[3] + ARn[4] + ARn[5]);
		retOut.reason1 = 100 * ARn[1] / (ALn[1] + ARn[1]);
		retOut.reason2 = 100 * ARn[2] / (ALn[2] + ARn[2]);
		retOut.reason3 = 100 * ARn[3] / (ALn[3] + ARn[3]);
		retOut.reason4 = 100 * ARn[4] / (ALn[4] + ARn[4]);
		retOut.reason5 = 100 * ARn[5] / (ALn[5] + ARn[5]);
		retOut.Sensibility1 = 100 * ALn[1] / (ALn[1] + ARn[1]);
		retOut.Sensibility2 = 100 * ALn[2] / (ALn[2] + ARn[2]);
		retOut.Sensibility3 = 100 * ALn[3] / (ALn[3] + ARn[3]);
		retOut.Sensibility4 = 100 * ALn[4] / (ALn[4] + ARn[4]);
		retOut.Sensibility5 = 100 * ALn[5] / (ALn[5] + ARn[5]);
		retOut.motivation = 100 * (ALn[1] + ARn[1]) / (ALn[1] + ARn[1] + ALn[2] + ARn[2]);
		retOut.Idea = 100 * (ALn[2] + ARn[2]) / (ALn[1] + ARn[1] + ALn[2] + ARn[2]);
		retOut.Visual = 100 * (ALn[5] + ARn[5]) / (ALn[3] + ARn[3] + ALn[4] + ARn[4] + ALn[5] + ARn[5]);
		retOut.AuditorySense = 100 * (ALn[4] + ARn[4]) / (ALn[3] + ARn[3] + ALn[4] + ARn[4] + ALn[5] + ARn[5]);
		retOut.Somatosensory = 100 * (ALn[3] + ARn[3]) / (ALn[3] + ARn[3] + ALn[4] + ARn[4] + ALn[5] + ARn[5]);

		return retOut;
	}

	public static void algorithmMain(String[] args) {
		System.out.println("start");
		algorithm malgorithm = new algorithm();
		algorithm.algorithmInput input = malgorithm.new algorithmInput();
		input.mFingerDataLeft[0].mFINGER_TYPE = FINGER_TYPE.Wt;
		input.mFingerDataLeft[0].RcBig = 15;
		input.mFingerDataLeft[0].RcSmall = 2;
		input.mFingerDataLeft[1].mFINGER_TYPE = FINGER_TYPE.Ae;
		input.mFingerDataLeft[1].RcBig = 13;
		input.mFingerDataLeft[1].RcSmall = 3;
		input.mFingerDataLeft[2].mFINGER_TYPE = FINGER_TYPE.At;
		input.mFingerDataLeft[2].RcBig = 14;
		input.mFingerDataLeft[2].RcSmall = 4;
		input.mFingerDataLeft[3].mFINGER_TYPE = FINGER_TYPE.R;
		input.mFingerDataLeft[3].RcBig = 11;
		input.mFingerDataLeft[3].RcSmall = 5;
		input.mFingerDataLeft[4].mFINGER_TYPE = FINGER_TYPE.Ux;
		input.mFingerDataLeft[4].RcBig = 10;
		input.mFingerDataLeft[4].RcSmall = 6;

		input.mFingerDataRight[0].mFINGER_TYPE = FINGER_TYPE.Wt;
		input.mFingerDataRight[0].RcBig = 15;
		input.mFingerDataRight[0].RcSmall = 2;
		input.mFingerDataRight[1].mFINGER_TYPE = FINGER_TYPE.Ae;
		input.mFingerDataRight[1].RcBig = 13;
		input.mFingerDataRight[1].RcSmall = 3;
		input.mFingerDataRight[2].mFINGER_TYPE = FINGER_TYPE.At;
		input.mFingerDataRight[2].RcBig = 14;
		input.mFingerDataRight[2].RcSmall = 4;
		input.mFingerDataRight[3].mFINGER_TYPE = FINGER_TYPE.R;
		input.mFingerDataRight[3].RcBig = 11;
		input.mFingerDataRight[3].RcSmall = 5;
		input.mFingerDataRight[4].mFINGER_TYPE = FINGER_TYPE.Ux;
		input.mFingerDataRight[4].RcBig = 10;
		input.mFingerDataRight[4].RcSmall = 6;

		algorithm.algorithmOutput output = malgorithm.Run(input);
	}
}