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
		public String L1temp; //����
		public String L2temp;
		public String L3temp;
		public String L4temp;
		public String L5temp;
		public String R1temp;
		public String R2temp;
		public String R3temp;
		public String R4temp;
		public String R5temp;
		public float intensityL1; // ǿ��
		public float intensityL2;
		public float intensityL3;
		public float intensityL4;
		public float intensityL5;
		public float intensityR1;
		public float intensityR2;
		public float intensityR3;
		public float intensityR4;
		public float intensityR5;
		public float LeftBrain;// ����
		public float RightBrain;// ����
		public float reason1;// ����
		public float reason2;
		public float reason3;
		public float reason4;
		public float reason5;
		public float Sensibility1;// ����
		public float Sensibility2;
		public float Sensibility3;
		public float Sensibility4;
		public float Sensibility5;
		public float motivation;// ����
		public float Idea;// ��˼
		public float Visual;// �Ӿ�
		public float AuditorySense;// ����
		public float Somatosensory;// ���
	}

	public algorithm() {
		;
	}

	public float GetTnWithFINGER_TYPE(FINGER_TYPE type, int index) {
		/*
		 * tn Wt:WsLn[We��Wc��Wd��Wi��Wx Wl��Rl��Wp��Rp U��R��Lf��Rf��Ux As��Ae��At��Au��Ar��Ax
		 * ���� --> Ĵָ t1 1 0.13333 0.14285 1.04657 ���� --> ʳָ t2 1 0.14285 0.15384
		 * 1.04657 ��֫�� --> ��ָ t3 1 0.15384 0.16667 1.04657 ������ --> ��ָ t4 1
		 * 0.16667 0.18182 1.04657 ��ͼ�� --> βָ t5 1 0.18182 0.19990 1.04657
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
		
		retOut.L1temp = input.mFingerDataLeft[0].mFINGER_TYPE.toString();
		retOut.L2temp = input.mFingerDataLeft[1].mFINGER_TYPE.toString();
		retOut.L3temp = input.mFingerDataLeft[2].mFINGER_TYPE.toString();
		retOut.L4temp = input.mFingerDataLeft[3].mFINGER_TYPE.toString();
		retOut.L5temp = input.mFingerDataRight[4].mFINGER_TYPE.toString();
		retOut.R1temp = input.mFingerDataRight[0].mFINGER_TYPE.toString();
		retOut.R2temp = input.mFingerDataRight[1].mFINGER_TYPE.toString();
		retOut.R3temp = input.mFingerDataRight[2].mFINGER_TYPE.toString();
		retOut.R4temp = input.mFingerDataRight[3].mFINGER_TYPE.toString();
		retOut.R5temp = input.mFingerDataRight[4].mFINGER_TYPE.toString();
		
		/*
		 * Amn=tn*Rc��*Rc�� m=��|�ң�n=1,2,3,4,5 ���ͣ�Wl��Rl��Wp��Rp��U��R��Lf��Rf��Ux
		 * Amn=Rc��+Rc�� m=��|�ң�n=1,2,3,4,5
		 * ���ͣ�Wt��Ws��We��Wc��Wd��Wi��As��Ae��At��Au��Ar��Wx��Ax
		 */

		/*
		Wt	0.80000(Rc��/RcС+1)	0.88500(Rc��/RcС+1)	0.88989(Rc��/RcС+1)	0.89519(Rc��/RcС+1)	1.00009(Rc��/RcС+1)	0.80000(Rc��/RcС+1)	0.88500(Rc��/RcС+1)	0.88989(Rc��/RcС+1)	0.89519(Rc��/RcС+1)	1.00009(Rc��/RcС+1)
		Ws	0.72500(Rc��/RcС+1)	0.82484(Rc��/RcС+1)	0.82989(Rc��/RcС+1)	0.83495(Rc��/RcС+1)	0.92526(Rc��/RcС+1)	0.72500(Rc��/RcС+1)	0.82484(Rc��/RcС+1)	0.82989(Rc��/RcС+1)	0.83495(Rc��/RcС+1)	0.92526(Rc��/RcС+1)
		We	0.64989(Rc��/RcС+1)	0.75474(Rc��/RcС+1)	0.75979(Rc��/RcС+1)	0.76484(Rc��/RcС+1)	0.80021(Rc��/RcС+1)	0.64989(Rc��/RcС+1)	0.75474(Rc��/RcС+1)	0.75979(Rc��/RcС+1)	0.76484(Rc��/RcС+1)	0.80021(Rc��/RcС+1)
		Wc	0.60505(Rc��/RcС+1)	0.61011(Rc��/RcС+1)	0.61516(Rc��/RcС+1)	0.62021(Rc��/RcС+1)	0.62526(Rc��/RcС+1)	0.60505(Rc��/RcС+1)	0.61011(Rc��/RcС+1)	0.61516(Rc��/RcС+1)	0.62021(Rc��/RcС+1)	0.62526(Rc��/RcС+1)
		Wd	0.69979(Rc��/RcС+1)	0.75474(Rc��/RcС+1)	0.75979(Rc��/RcС+1)	0.76505(Rc��/RcС+1)	0.80021(Rc��/RcС+1)	0.69979(Rc��/RcС+1)	0.75474(Rc��/RcС+1)	0.75979(Rc��/RcС+1)	0.76505(Rc��/RcС+1)	0.80021(Rc��/RcС+1)
		Wi	0.60000(Rc��/RcС+1)	0.65495(Rc��/RcС+1)	0.66000(Rc��/RcС+1)	0.66505(Rc��/RcС+1)	0.69979(Rc��/RcС+1)	0.60000(Rc��/RcС+1)	0.65495(Rc��/RcС+1)	0.66000(Rc��/RcС+1)	0.66505(Rc��/RcС+1)	0.69979(Rc��/RcС+1)
		Wp	0.08667Rc	0.10071Rc	0.10922Rc	0.11916Rc	0.13637Rc	0.08667Rc	0.10071Rc	0.10922Rc	0.11916Rc	0.13637Rc
		Rp	0.08667Rc	0.10071Rc	0.10922Rc	0.11916Rc	0.13637Rc	0.08667Rc	0.10071Rc	0.10922Rc	0.11916Rc	0.13637Rc
		Wl	0.08333Rc	0.09643Rc	0.10461Rc	0.11416Rc	0.13182Rc	0.08333Rc	0.09643Rc	0.10461Rc	0.11416Rc	0.13182Rc
		Rl	0.08333Rc	0.09643Rc	0.10461Rc	0.11416Rc	0.13182Rc	0.08333Rc	0.09643Rc	0.10461Rc	0.11416Rc	0.13182Rc
		U	0.07358Rc	0.08000Rc	0.08500Rc	0.09182Rc	1.00000Rc	0.07358Rc	0.08000Rc	0.08500Rc	0.09182Rc	1.00000Rc
		R	0.09786Rc	0.11538Rc	0.11334Rc	0.12273Rc	0.11500Rc	0.09786Rc	0. 11538Rc	0. 11334Rc	0.12273Rc	0.11500Rc
		Lf	0.05714Rc	0.06539Rc	0.05833Rc	0.07727Rc	0.07500Rc	0.05714Rc	0.06539Rc	0.05833Rc	0.07727Rc	0.07500Rc
		Rf	0.05714Rc	0.06539Rc	0.05833Rc	0.07727Rc	0.07500Rc	0.05714Rc	0.06539Rc	0.05833Rc	0.07727Rc	0.07500Rc
		As	0.308 	0.297 	0.385 	0.286 	0.275 	0.294 	0.283 	0.367 	0.273 	0.262 
		Ae	0.418 	0.407 	0.495 	0.396 	0.385 	0.399 	0.388 	0.472 	0.378 	0.367 
		At	1.485 	1.540 	1.705 	1.595 	1.430 	1.417 	1.470 	1.627 	1.522 	1.365 
		Au	0.572 	0.671 	0.682 	0.561 	0.550 	0.546 	0.640 	0.651 	0.535 	0.525 
		Ar	0.682 	0.781 	0.792 	0.671 	0.660 	0.651 	0.745 	0.756 	0.640 	0.630 
		Wx	0.50526(Rc��/RcС+1)	0.51003(Rc��/RcС+1)	0.51474(Rc��/RcС+1)	0.51979(Rc��/RcС+1)	0.52528(Rc��/RcС+1)	0.50526(Rc��/RcС+1)	0.51003(Rc��/RcС+1)	0.51474(Rc��/RcС+1)	0.51979(Rc��/RcС+1)	0.52528(Rc��/RcС+1)
		Ux	0.07214Rc��	0.07846Rc��	0.08583Rc��	0.09455Rc��	0.10500Rc��	0.07214Rc��	0.07846Rc��	0.08583Rc��	0.09455Rc��	0.10500Rc��
		Ax	1.111 	1.122 	1.133 	1.144 	1.155 	1.060 	1.071 	1.081 	1.092 	1.102 
*/
		// ǿ�ȼ���
		// L1
		switch(input.mFingerDataLeft[0].mFINGER_TYPE) {
		case Wt:	retOut.intensityL1 = 0.80000f*(input.mFingerDataLeft[0].RcBig/input.mFingerDataLeft[0].RcSmall+1); break;
		case Ws:	retOut.intensityL1 = 0.72500f*(input.mFingerDataLeft[0].RcBig/input.mFingerDataLeft[0].RcSmall+1); break;
		case We:	retOut.intensityL1 = 0.64989f*(input.mFingerDataLeft[0].RcBig/input.mFingerDataLeft[0].RcSmall+1); break;
		case Wc:	retOut.intensityL1 = 0.60505f*(input.mFingerDataLeft[0].RcBig/input.mFingerDataLeft[0].RcSmall+1); break;
		case Wd:	retOut.intensityL1 = 0.69979f*(input.mFingerDataLeft[0].RcBig/input.mFingerDataLeft[0].RcSmall+1); break;
		case Wi:	retOut.intensityL1 = 0.60000f*(input.mFingerDataLeft[0].RcBig/input.mFingerDataLeft[0].RcSmall+1); break;
		case Wp:	retOut.intensityL1 = 0.08667f*input.mFingerDataLeft[0].RcBig; break;
		case Rp:	retOut.intensityL1 = 0.08667f*input.mFingerDataLeft[0].RcBig; break;
		case Wl:	retOut.intensityL1 = 0.08333f*input.mFingerDataLeft[0].RcBig; break;
		case Rl:	retOut.intensityL1 = 0.08333f*input.mFingerDataLeft[0].RcBig; break;
		case U:		retOut.intensityL1 = 0.07358f*input.mFingerDataLeft[0].RcBig; break;
		case R:		retOut.intensityL1 = 0.09786f*input.mFingerDataLeft[0].RcBig; break;
		case Lf:	retOut.intensityL1 = 0.05714f*input.mFingerDataLeft[0].RcBig; break;
		case Rf:	retOut.intensityL1 = 0.05714f*input.mFingerDataLeft[0].RcBig; break;
		case As:	retOut.intensityL1 = 0.308f ; break;
		case Ae:	retOut.intensityL1 = 0.418f ; break;
		case At:	retOut.intensityL1 = 1.485f ; break;
		case Au:	retOut.intensityL1 = 0.572f ; break;
		case Ar:	retOut.intensityL1 = 0.682f ; break;
		case Wx:	retOut.intensityL1 = 0.50526f*(input.mFingerDataLeft[0].RcBig/input.mFingerDataLeft[0].RcSmall+1); break;
		case Ux:	retOut.intensityL1 = 0.07214f*input.mFingerDataLeft[0].RcBig; break;
		case Ax:	retOut.intensityL1 = 1.111f ; break;
		}
		//L2
		switch(input.mFingerDataLeft[1].mFINGER_TYPE) {
		case Wt:	retOut.intensityL2 = 0.88500f*(input.mFingerDataLeft[1].RcBig/input.mFingerDataLeft[1].RcSmall+1); break;
		case Ws:	retOut.intensityL2 = 0.82484f*(input.mFingerDataLeft[1].RcBig/input.mFingerDataLeft[1].RcSmall+1); break;
		case We:	retOut.intensityL2 = 0.75474f*(input.mFingerDataLeft[1].RcBig/input.mFingerDataLeft[1].RcSmall+1); break;
		case Wc:	retOut.intensityL2 = 0.61011f*(input.mFingerDataLeft[1].RcBig/input.mFingerDataLeft[1].RcSmall+1); break;
		case Wd:	retOut.intensityL2 = 0.75474f*(input.mFingerDataLeft[1].RcBig/input.mFingerDataLeft[1].RcSmall+1); break;
		case Wi:	retOut.intensityL2 = 0.65495f*(input.mFingerDataLeft[1].RcBig/input.mFingerDataLeft[1].RcSmall+1); break;
		case Wp:	retOut.intensityL2 = 0.10071f*input.mFingerDataLeft[1].RcBig; break;
		case Rp:	retOut.intensityL2 = 0.10071f*input.mFingerDataLeft[1].RcBig; break;
		case Wl:	retOut.intensityL2 = 0.09643f*input.mFingerDataLeft[1].RcBig; break;
		case Rl:	retOut.intensityL2 = 0.09643f*input.mFingerDataLeft[1].RcBig; break;
		case U:		retOut.intensityL2 = 0.08000f*input.mFingerDataLeft[1].RcBig; break;
		case R:		retOut.intensityL2 = 0.11538f*input.mFingerDataLeft[1].RcBig; break;
		case Lf:	retOut.intensityL2 = 0.06539f*input.mFingerDataLeft[1].RcBig; break;
		case Rf:	retOut.intensityL2 = 0.06539f*input.mFingerDataLeft[1].RcBig; break;
		case As:	retOut.intensityL2 = 0.297f ; break;
		case Ae:	retOut.intensityL2 = 0.407f ; break;
		case At:	retOut.intensityL2 = 1.540f ; break;
		case Au:	retOut.intensityL2 = 0.671f ; break;
		case Ar:	retOut.intensityL2 = 0.781f ; break;
		case Wx:	retOut.intensityL2 = 0.51003f*(input.mFingerDataLeft[1].RcBig/input.mFingerDataLeft[1].RcSmall+1); break;
		case Ux:	retOut.intensityL2 = 0.07846f*input.mFingerDataLeft[1].RcBig; break;
		case Ax:	retOut.intensityL2 = 1.122f ; break;
		}
		// L3
		switch(input.mFingerDataLeft[2].mFINGER_TYPE) {
		case Wt: retOut.intensityL3	= 0.88989f*(input.mFingerDataLeft[2].RcBig/input.mFingerDataLeft[2].RcSmall+1); break;
		case Ws: retOut.intensityL3	= 	0.82989f*(input.mFingerDataLeft[2].RcBig/input.mFingerDataLeft[2].RcSmall+1); break;
		case We: retOut.intensityL3	= 	0.75979f*(input.mFingerDataLeft[2].RcBig/input.mFingerDataLeft[2].RcSmall+1); break;
		case Wc: retOut.intensityL3	= 	0.61516f*(input.mFingerDataLeft[2].RcBig/input.mFingerDataLeft[2].RcSmall+1); break;
		case Wd: retOut.intensityL3	= 	0.75979f*(input.mFingerDataLeft[2].RcBig/input.mFingerDataLeft[2].RcSmall+1); break;
		case Wi: retOut.intensityL3	= 	0.66000f*(input.mFingerDataLeft[2].RcBig/input.mFingerDataLeft[2].RcSmall+1); break;
		case Wp: retOut.intensityL3	= 	0.10922f*input.mFingerDataLeft[2].RcBig; break;
		case Rp: retOut.intensityL3	= 	0.10922f*input.mFingerDataLeft[2].RcBig; break;
		case Wl: retOut.intensityL3	= 	0.10461f*input.mFingerDataLeft[2].RcBig; break;
		case Rl: retOut.intensityL3	= 	0.10461f*input.mFingerDataLeft[2].RcBig; break;
		case U: retOut.intensityL3	= 	0.08500f*input.mFingerDataLeft[2].RcBig; break;
		case R: retOut.intensityL3	= 	0.11334f*input.mFingerDataLeft[2].RcBig; break;
		case Lf: retOut.intensityL3	= 	0.05833f*input.mFingerDataLeft[2].RcBig; break;
		case Rf: retOut.intensityL3	= 	0.05833f*input.mFingerDataLeft[2].RcBig; break;
		case As: retOut.intensityL3	= 	0.385f ; break;
		case Ae: retOut.intensityL3	= 	0.495f ; break;
		case At: retOut.intensityL3	= 	1.705f ; break;
		case Au: retOut.intensityL3	= 	0.682f ; break;
		case Ar: retOut.intensityL3	= 	0.792f ; break;
		case Wx: retOut.intensityL3	= 	0.51474f*(input.mFingerDataLeft[2].RcBig/input.mFingerDataLeft[2].RcSmall+1); break;
		case Ux: retOut.intensityL3	= 	0.08583f*input.mFingerDataLeft[2].RcBig; break;
		case Ax: retOut.intensityL3	= 	1.133f ; break;
		}

		//L4
		switch(input.mFingerDataLeft[3].mFINGER_TYPE) {
		case Wt	: retOut.intensityL4 = 0.89519f*(input.mFingerDataLeft[3].RcBig/input.mFingerDataLeft[3].RcSmall+1); break;
		case Ws	: retOut.intensityL4 =0.83495f*(input.mFingerDataLeft[3].RcBig/input.mFingerDataLeft[3].RcSmall+1); break;
		case We	: retOut.intensityL4 =0.76484f*(input.mFingerDataLeft[3].RcBig/input.mFingerDataLeft[3].RcSmall+1); break;
		case Wc	: retOut.intensityL4 =0.62021f*(input.mFingerDataLeft[3].RcBig/input.mFingerDataLeft[3].RcSmall+1); break;
		case Wd	: retOut.intensityL4 =0.76505f*(input.mFingerDataLeft[3].RcBig/input.mFingerDataLeft[3].RcSmall+1); break;
		case Wi	: retOut.intensityL4 =0.66505f*(input.mFingerDataLeft[3].RcBig/input.mFingerDataLeft[3].RcSmall+1); break;
		case Wp	: retOut.intensityL4 =0.11916f*input.mFingerDataLeft[3].RcBig; break;
		case Rp	: retOut.intensityL4 =0.11916f*input.mFingerDataLeft[3].RcBig; break;
		case Wl	: retOut.intensityL4 =0.11416f*input.mFingerDataLeft[3].RcBig; break;
		case Rl	: retOut.intensityL4 =0.11416f*input.mFingerDataLeft[3].RcBig; break;
		case U	: retOut.intensityL4 =0.09182f*input.mFingerDataLeft[3].RcBig; break;
		case R	: retOut.intensityL4 =0.12273f*input.mFingerDataLeft[3].RcBig; break;
		case Lf	: retOut.intensityL4 =0.07727f*input.mFingerDataLeft[3].RcBig; break;
		case Rf	: retOut.intensityL4 =0.07727f*input.mFingerDataLeft[3].RcBig; break;
		case As	: retOut.intensityL4 =0.286f ; break;
		case Ae	: retOut.intensityL4 =0.396f ; break;
		case At	: retOut.intensityL4 =1.595f ; break;
		case Au	: retOut.intensityL4 =0.561f ; break;
		case Ar	: retOut.intensityL4 =0.671f ; break;
		case Wx	: retOut.intensityL4 =0.51979f*(input.mFingerDataLeft[3].RcBig/input.mFingerDataLeft[3].RcSmall+1); break;
		case Ux	: retOut.intensityL4 =0.09455f*input.mFingerDataLeft[3].RcBig; break;
		case Ax	: retOut.intensityL4 =1.144f; break;
		}
		//L5
		switch(input.mFingerDataLeft[4].mFINGER_TYPE) {
		case Wt	: retOut.intensityL5 =1.00009f*(input.mFingerDataLeft[4].RcBig/input.mFingerDataLeft[4].RcSmall+1); break;
		case Ws	: retOut.intensityL5 =0.92526f*(input.mFingerDataLeft[4].RcBig/input.mFingerDataLeft[4].RcSmall+1); break;
		case We	: retOut.intensityL5 =0.80021f*(input.mFingerDataLeft[4].RcBig/input.mFingerDataLeft[4].RcSmall+1); break;
		case Wc	: retOut.intensityL5 =0.62526f*(input.mFingerDataLeft[4].RcBig/input.mFingerDataLeft[4].RcSmall+1); break;
		case Wd	: retOut.intensityL5 =0.80021f*(input.mFingerDataLeft[4].RcBig/input.mFingerDataLeft[4].RcSmall+1); break;
		case Wi	: retOut.intensityL5 =0.69979f*(input.mFingerDataLeft[4].RcBig/input.mFingerDataLeft[4].RcSmall+1); break;
		case Wp	: retOut.intensityL5 =0.13637f*input.mFingerDataLeft[4].RcBig; break;
		case Rp	: retOut.intensityL5 =0.13637f*input.mFingerDataLeft[4].RcBig; break;
		case Wl	: retOut.intensityL5 =0.13182f*input.mFingerDataLeft[4].RcBig; break;
		case Rl	: retOut.intensityL5 =0.13182f*input.mFingerDataLeft[4].RcBig; break;
		case U	: retOut.intensityL5 =1.00000f*input.mFingerDataLeft[4].RcBig; break;
		case R	: retOut.intensityL5 =0.11500f*input.mFingerDataLeft[4].RcBig; break;
		case Lf	: retOut.intensityL5 =0.07500f*input.mFingerDataLeft[4].RcBig; break;
		case Rf	: retOut.intensityL5 =0.07500f*input.mFingerDataLeft[4].RcBig; break;
		case As	: retOut.intensityL5 =0.275f ; break;
		case Ae	: retOut.intensityL5 =0.385f ; break;
		case At	: retOut.intensityL5 =1.430f ; break;
		case Au	: retOut.intensityL5 =0.550f ; break;
		case Ar	: retOut.intensityL5 =0.660f ; break;
		case Wx	: retOut.intensityL5 =0.52528f*(input.mFingerDataLeft[4].RcBig/input.mFingerDataLeft[4].RcSmall+1); break;
		case Ux	: retOut.intensityL5 =0.10500f*input.mFingerDataLeft[4].RcBig; break;
		case Ax	: retOut.intensityL5 =1.155f ; break;
		}
		//R1
		switch(input.mFingerDataRight[0].mFINGER_TYPE) {
		case Wt	: retOut.intensityR1 =0.80000f*(input.mFingerDataRight[0].RcBig/input.mFingerDataRight[0].RcSmall+1); break;
		case Ws	: retOut.intensityR1 =0.72500f*(input.mFingerDataRight[0].RcBig/input.mFingerDataRight[0].RcSmall+1); break;
		case We	: retOut.intensityR1 =0.64989f*(input.mFingerDataRight[0].RcBig/input.mFingerDataRight[0].RcSmall+1); break;
		case Wc	: retOut.intensityR1 =0.60505f*(input.mFingerDataRight[0].RcBig/input.mFingerDataRight[0].RcSmall+1); break;
		case Wd	: retOut.intensityR1 =0.69979f*(input.mFingerDataRight[0].RcBig/input.mFingerDataRight[0].RcSmall+1); break;
		case Wi	: retOut.intensityR1 =0.60000f*(input.mFingerDataRight[0].RcBig/input.mFingerDataRight[0].RcSmall+1); break;
		case Wp	: retOut.intensityR1 =0.08667f*input.mFingerDataRight[0].RcBig; break;
		case Rp	: retOut.intensityR1 =0.08667f*input.mFingerDataRight[0].RcBig; break;
		case Wl	: retOut.intensityR1 =0.08333f*input.mFingerDataRight[0].RcBig; break;
		case Rl	: retOut.intensityR1 =0.08333f*input.mFingerDataRight[0].RcBig; break;
		case U	: retOut.intensityR1 =0.07358f*input.mFingerDataRight[0].RcBig; break;
		case R	: retOut.intensityR1 =0.09786f*input.mFingerDataRight[0].RcBig; break;
		case Lf	: retOut.intensityR1 =0.05714f*input.mFingerDataRight[0].RcBig; break;
		case Rf	: retOut.intensityR1 =0.05714f*input.mFingerDataRight[0].RcBig; break;
		case As	: retOut.intensityR1 =0.294f ; break;
		case Ae	: retOut.intensityR1 =0.399f ; break;
		case At	: retOut.intensityR1 =1.417f ; break;
		case Au	: retOut.intensityR1 =0.546f ; break;
		case Ar	: retOut.intensityR1 =0.651f ; break;
		case Wx	: retOut.intensityR1 =0.50526f*(input.mFingerDataRight[0].RcBig/input.mFingerDataRight[0].RcSmall+1); break;
		case Ux	: retOut.intensityR1 =0.07214f*input.mFingerDataRight[0].RcBig; break;
		case Ax	: retOut.intensityR1 =1.060f ; break;

		}
		//R2
		switch(input.mFingerDataRight[1].mFINGER_TYPE) {
		case Wt	: retOut.intensityR2 =0.88500f*(input.mFingerDataRight[1].RcBig/input.mFingerDataRight[1].RcSmall+1); break;
		case Ws	: retOut.intensityR2 =0.82484f*(input.mFingerDataRight[1].RcBig/input.mFingerDataRight[1].RcSmall+1); break;
		case We	: retOut.intensityR2 =0.75474f*(input.mFingerDataRight[1].RcBig/input.mFingerDataRight[1].RcSmall+1); break;
		case Wc	: retOut.intensityR2 =0.61011f*(input.mFingerDataRight[1].RcBig/input.mFingerDataRight[1].RcSmall+1); break;
		case Wd	: retOut.intensityR2 =0.75474f*(input.mFingerDataRight[1].RcBig/input.mFingerDataRight[1].RcSmall+1); break;
		case Wi	: retOut.intensityR2 =0.65495f*(input.mFingerDataRight[1].RcBig/input.mFingerDataRight[1].RcSmall+1); break;
		case Wp	: retOut.intensityR2 =0.10071f*input.mFingerDataRight[1].RcBig; break;
		case Rp	: retOut.intensityR2 =0.10071f*input.mFingerDataRight[1].RcBig; break;
		case Wl	: retOut.intensityR2 =0.09643f*input.mFingerDataRight[1].RcBig; break;
		case Rl	: retOut.intensityR2 =0.09643f*input.mFingerDataRight[1].RcBig; break;
		case U	: retOut.intensityR2 =0.08000f*input.mFingerDataRight[1].RcBig; break;
		case R	: retOut.intensityR2 =0.11538f*input.mFingerDataRight[1].RcBig; break;
		case Lf	: retOut.intensityR2 =0.06539f*input.mFingerDataRight[1].RcBig; break;
		case Rf	: retOut.intensityR2 =0.06539f*input.mFingerDataRight[1].RcBig; break;
		case As	: retOut.intensityR2 =0.283f ; break;
		case Ae	: retOut.intensityR2 =0.388f ; break;
		case At	: retOut.intensityR2 =1.470f ; break;
		case Au	: retOut.intensityR2 =0.640f ; break;
		case Ar	: retOut.intensityR2 =0.745f ; break;
		case Wx	: retOut.intensityR2 =0.51003f*(input.mFingerDataRight[1].RcBig/input.mFingerDataRight[1].RcSmall+1); break;
		case Ux	: retOut.intensityR2 =0.07846f*input.mFingerDataRight[1].RcBig; break;
		case Ax	: retOut.intensityR2 =1.071f ; break;

		}
		//R3
		switch(input.mFingerDataRight[2].mFINGER_TYPE) {
		case Wt: retOut.intensityR3 =	0.88989f*(input.mFingerDataRight[2].RcBig/input.mFingerDataRight[2].RcSmall+1); break;
		case Ws: retOut.intensityR3 =	0.82989f*(input.mFingerDataRight[2].RcBig/input.mFingerDataRight[2].RcSmall+1); break;
		case We: retOut.intensityR3 =	0.75979f*(input.mFingerDataRight[2].RcBig/input.mFingerDataRight[2].RcSmall+1); break;
		case Wc: retOut.intensityR3 =	0.61516f*(input.mFingerDataRight[2].RcBig/input.mFingerDataRight[2].RcSmall+1); break;
		case Wd: retOut.intensityR3 =	0.75979f*(input.mFingerDataRight[2].RcBig/input.mFingerDataRight[2].RcSmall+1); break;
		case Wi: retOut.intensityR3 =	0.66000f*(input.mFingerDataRight[2].RcBig/input.mFingerDataRight[2].RcSmall+1); break;
		case Wp: retOut.intensityR3 =	0.10922f*input.mFingerDataRight[2].RcBig; break;
		case Rp: retOut.intensityR3 =	0.10922f*input.mFingerDataRight[2].RcBig; break;
		case Wl: retOut.intensityR3 =	0.10461f*input.mFingerDataRight[2].RcBig; break;
		case Rl: retOut.intensityR3 =	0.10461f*input.mFingerDataRight[2].RcBig; break;
		case U: retOut.intensityR3 =	0.08500f*input.mFingerDataRight[2].RcBig; break;
		case R: retOut.intensityR3 =	0.11334f*input.mFingerDataRight[2].RcBig; break;
		case Lf: retOut.intensityR3 =	0.05833f*input.mFingerDataRight[2].RcBig; break;
		case Rf: retOut.intensityR3 =	0.05833f*input.mFingerDataRight[2].RcBig; break;
		case As: retOut.intensityR3 =	0.367f ; break;
		case Ae: retOut.intensityR3 =	0.472f ; break;
		case At: retOut.intensityR3 =	1.627f ; break;
		case Au: retOut.intensityR3 =	0.651f ; break;
		case Ar: retOut.intensityR3 =	0.756f ; break;
		case Wx: retOut.intensityR3 =	0.51474f*(input.mFingerDataRight[2].RcBig/input.mFingerDataRight[2].RcSmall+1); break;
		case Ux: retOut.intensityR3 =	0.08583f*input.mFingerDataRight[2].RcBig; break;
		case Ax: retOut.intensityR3 =	1.081f ; break;

		}
		switch(input.mFingerDataRight[3].mFINGER_TYPE) {
		case Wt: retOut.intensityR4 =	0.89519f*(input.mFingerDataRight[3].RcBig/input.mFingerDataRight[3].RcSmall+1); break;
		case Ws: retOut.intensityR4 =	0.83495f*(input.mFingerDataRight[3].RcBig/input.mFingerDataRight[3].RcSmall+1); break;
		case We: retOut.intensityR4 =	0.76484f*(input.mFingerDataRight[3].RcBig/input.mFingerDataRight[3].RcSmall+1); break;
		case Wc: retOut.intensityR4 =	0.62021f*(input.mFingerDataRight[3].RcBig/input.mFingerDataRight[3].RcSmall+1); break;
		case Wd: retOut.intensityR4 =	0.76505f*(input.mFingerDataRight[3].RcBig/input.mFingerDataRight[3].RcSmall+1); break;
		case Wi: retOut.intensityR4 =	0.66505f*(input.mFingerDataRight[3].RcBig/input.mFingerDataRight[3].RcSmall+1); break;
		case Wp: retOut.intensityR4 =	0.11916f*input.mFingerDataRight[3].RcBig; break;
		case Rp: retOut.intensityR4 =	0.11916f*input.mFingerDataRight[3].RcBig; break;
		case Wl: retOut.intensityR4 =	0.11416f*input.mFingerDataRight[3].RcBig; break;
		case Rl: retOut.intensityR4 =	0.11416f*input.mFingerDataRight[3].RcBig; break;
		case U: retOut.intensityR4 =	0.09182f*input.mFingerDataRight[3].RcBig; break;
		case R: retOut.intensityR4 =	0.12273f*input.mFingerDataRight[3].RcBig; break;
		case Lf: retOut.intensityR4 =	0.07727f*input.mFingerDataRight[3].RcBig; break;
		case Rf: retOut.intensityR4 =	0.07727f*input.mFingerDataRight[3].RcBig; break;
		case As: retOut.intensityR4 =	0.273f ; break;
		case Ae: retOut.intensityR4 =	0.378f ; break;
		case At: retOut.intensityR4 =	1.522f ; break;
		case Au: retOut.intensityR4 =	0.535f ; break;
		case Ar: retOut.intensityR4 =	0.640f ; break;
		case Wx: retOut.intensityR4 =	0.51979f*(input.mFingerDataRight[3].RcBig/input.mFingerDataRight[3].RcSmall+1); break;
		case Ux: retOut.intensityR4 =	0.09455f*input.mFingerDataRight[3].RcBig; break;
		case Ax: retOut.intensityR4 =	1.092f ; break;
		}
		switch(input.mFingerDataRight[4].mFINGER_TYPE) {
		case Wt	: retOut.intensityR5 =1.00009f*(input.mFingerDataRight[4].RcBig/input.mFingerDataRight[4].RcSmall+1); break;
		case Ws	: retOut.intensityR5 =0.92526f*(input.mFingerDataRight[4].RcBig/input.mFingerDataRight[4].RcSmall+1); break;
		case We	: retOut.intensityR5 =0.80021f*(input.mFingerDataRight[4].RcBig/input.mFingerDataRight[4].RcSmall+1); break;
		case Wc	: retOut.intensityR5 =0.62526f*(input.mFingerDataRight[4].RcBig/input.mFingerDataRight[4].RcSmall+1); break;
		case Wd	: retOut.intensityR5 =0.80021f*(input.mFingerDataRight[4].RcBig/input.mFingerDataRight[4].RcSmall+1); break;
		case Wi	: retOut.intensityR5 =0.69979f*(input.mFingerDataRight[4].RcBig/input.mFingerDataRight[4].RcSmall+1); break;
		case Wp	: retOut.intensityR5 =0.13637f*input.mFingerDataRight[4].RcBig; break;
		case Rp	: retOut.intensityR5 =0.13637f*input.mFingerDataRight[4].RcBig; break;
		case Wl	: retOut.intensityR5 =0.13182f*input.mFingerDataRight[4].RcBig; break;
		case Rl	: retOut.intensityR5 =0.13182f*input.mFingerDataRight[4].RcBig; break;
		case U	: retOut.intensityR5 =1.00000f*input.mFingerDataRight[4].RcBig; break;
		case R	: retOut.intensityR5 =0.11500f*input.mFingerDataRight[4].RcBig; break;
		case Lf	: retOut.intensityR5 =0.07500f*input.mFingerDataRight[4].RcBig; break;
		case Rf	: retOut.intensityR5 =0.07500f*input.mFingerDataRight[4].RcBig; break;
		case As	: retOut.intensityR5 =0.262f ; break;
		case Ae	: retOut.intensityR5 =0.367f ; break;
		case At	: retOut.intensityR5 =1.365f ; break;
		case Au	: retOut.intensityR5 =0.525f ; break;
		case Ar	: retOut.intensityR5 =0.630f ; break;
		case Wx	: retOut.intensityR5 =0.52528f*(input.mFingerDataRight[4].RcBig/input.mFingerDataRight[4].RcSmall+1); break;
		case Ux	: retOut.intensityR5 =0.10500f*input.mFingerDataRight[4].RcBig; break;
		case Ax	: retOut.intensityR5 =1.102f ; break;
		}
		
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
		 * ����
		 * 100*(A��1+A��2+A��3+A��4+A��5)/(A��1+A��2+A��3+A��4+A��5+A��1+A��2+A��3+A��4+A��5)
		 * ����
		 * 100*(A��1+A��2+A��3+A��4+A��5)/(A��1+A��2+A��3+A��4+A��5+A��1+A��2+A��3+A��4+A��5)
		 * ���� 100*A��n/(A��n+A��n�� ��% ���� 100*A��n/(A��n+A��n�� ��% ����
		 * 100*(A��1+A��1)/(A��1+A��1+A��2+A��2) ��% ��˼ 100*(A��2+A��2)/(A��1+A��1+A��2+A��2)
		 * ��% �Ӿ� 100*(A��5+A��5)/(A��3+A��3+A��4+A��4+A��5+A��5) ��% ����
		 * 100*(A��4+A��4)/(A��3+A��3+A��4+A��4+A��5+A��5) ��% ���
		 * 100*(A��3+A��3)/(A��3+A��3+A��4+A��4+A��5+A��5) ��% //
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

		retOut.intensityL1 = (float)(Math.round(retOut.intensityL1*1000))/1000; // ǿ��
		retOut.intensityL2 = (float)(Math.round(retOut.intensityL2*1000))/1000;
		retOut.intensityL3 = (float)(Math.round(retOut.intensityL3*1000))/1000;
		retOut.intensityL4 = (float)(Math.round(retOut.intensityL4*1000))/1000;
		retOut.intensityL5 = (float)(Math.round(retOut.intensityL5*1000))/1000;
		retOut.intensityR1 = (float)(Math.round(retOut.intensityR1*1000))/1000;
		retOut.intensityR2 = (float)(Math.round(retOut.intensityR2*1000))/1000;
		retOut.intensityR3 = (float)(Math.round(retOut.intensityR3*1000))/1000;
		retOut.intensityR4 = (float)(Math.round(retOut.intensityR4*1000))/1000;
		retOut.intensityR5 = (float)(Math.round(retOut.intensityR5*1000))/1000;
		retOut.LeftBrain = (float)(Math.round(retOut.LeftBrain*1000))/1000;// ����
		retOut.RightBrain = (float)(Math.round(retOut.RightBrain*1000))/1000;// ����
		retOut.reason1 = (float)(Math.round(retOut.reason1*1000))/1000;// ����
		retOut.reason2 = (float)(Math.round(retOut.reason2*1000))/1000;
		retOut.reason3 = (float)(Math.round(retOut.reason3*1000))/1000;
		retOut.reason4 = (float)(Math.round(retOut.reason4*1000))/1000;
		retOut.reason5 = (float)(Math.round(retOut.reason5*1000))/1000;
		retOut.Sensibility1 = (float)(Math.round(retOut.Sensibility1*1000))/1000;// ����
		retOut.Sensibility2 = (float)(Math.round(retOut.Sensibility2*1000))/1000;
		retOut.Sensibility3 = (float)(Math.round(retOut.Sensibility3*1000))/1000;
		retOut.Sensibility4 = (float)(Math.round(retOut.Sensibility4*1000))/1000;
		retOut.Sensibility5 = (float)(Math.round(retOut.Sensibility5*1000))/1000;
		retOut.motivation = (float)(Math.round(retOut.motivation*1000))/1000;// ����
		retOut.Idea = (float)(Math.round(retOut.Idea*1000))/1000;// ��˼
		retOut.Visual = (float)(Math.round(retOut.Visual*1000))/1000;// �Ӿ�
		retOut.AuditorySense = (float)(Math.round(retOut.AuditorySense*1000))/1000;// ����
		retOut.Somatosensory = (float)(Math.round(retOut.Somatosensory*1000))/1000;// ���
		
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