package main

import (
	"context"
	"encoding/json"
	"flag"
	"fmt"
	"log"
	"time"

	om "orbitManeuver/proto/om"

	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

var (
	addr = flag.String("addr", "0.0.0.0:50055", "the address to connect to")
)

func main() {

	flag.Parse()
	// Set up a connection to the server.
	conn, err := grpc.Dial(*addr, grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()
	c := om.NewRunOMClient(conn)

	// Contact the server and print out its response.
	ctx, cancel := context.WithTimeout(context.Background(), 1000*time.Second)
	defer cancel()

	// targetInput := []float64{6778000.0, 0.002, 97.0001258, 60.0, 20.0, 10.0}
	// chaseInput := []float64{6678000.0, 0.002, 96.0, 60.0, 20.0, 80.0}

	// omInput := om.RunOMInput{
	// 	TargetEpoch:      "2022-12-15 00:00:00.000",
	// 	ITargetInputType: 0,
	// 	DTargetInputData: targetInput,
	// 	//
	// 	ChaseEpoch:      "2022-12-15 00:00:00.000",
	// 	IChaseInputType: 0,
	// 	DChaseInputData: chaseInput,
	// 	//
	// 	ChaseMass:     1000.0,
	// 	Isp:           300.0,
	// 	IOMType:       0,
	// 	DDistanceInP:  30000.0,
	// 	DDistanceOutP: 10000.0,
	// }
	/*
		targetInput := []float64{24541178.63736882,
			-34290419.166117996,
			-241808.2160229358,
			2500.674114486614,
			1788.3505847242568,
			-21.3264494785416}
		chaseInput := []float64{41575844.06619419,
			6702258.795781168,
			-201399.06025841093,
			-489.70873614518564,
			3037.427864013822,
			3.3727674125038503}

		omInput := om.RunOMInput{
			TargetEpoch:      "2023-05-22 00:00:00.000",
			ITargetInputType: 1,
			DTargetInputData: targetInput,
			//
			ChaseEpoch:      "2023-05-22 00:00:00.000",
			IChaseInputType: 1,
			DChaseInputData: chaseInput,
			//
			ChaseMass:     1000.0,
			Isp:           300.0,
			IOMType:       0,
			DDistanceInP:  30000.0,
			DDistanceOutP: 10000.0,
		}
		if rejson, err := json.MarshalIndent(omInput, "   ", " "); err != nil {
			fmt.Println(err)
			return
		} else {
			log.Printf("%s", string(rejson))
		}

		r, err := c.GetOM(ctx, &omInput)
		if err != nil {
			fmt.Println(r.GetStatus().String())
		} else {
			//将返回的r转换为json
			if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
				fmt.Println(err)
				return
			} else {
				log.Printf("%s", string(rejson))
			}
		}

		//轨道倾角机动测试
		testOrbitPV := []float64{6678137.000, -0.000, -1.401, 0.000774, 6789.530456, 3686.413881}
		omInc := om.RunIncInput{
			Epoch:      "2023-04-10 04:00:00.000",
			DInputData: testOrbitPV,
			DeltaI:     -5.0,
		}

		if r, err := c.GetInc(ctx, &omInc); err != nil {
			fmt.Println(err)
		} else {
			fmt.Println(r.DOutData)
		}

		//测试巡视机动
		inspection := []float64{42166300.0, 0.000, 0.128828, 0.0, 90.7764, 302.657}

		omIns := om.RunHoInsInput{
			TargetEpoch:      "2023-05-08 04:00:00.000",
			ITargetInputType: 0,
			DTargetInputData: inspection,
			//
			//
			SatMass:     1000.0,
			Isp:         300.0,
			InsStarTime: "2023-05-08 14:00:00.000",
			InsD:        1,
			InsEW:       1,
		}
		if r, err := c.HoInspection(ctx, &omIns); err != nil {
			fmt.Println(err)
		} else {
			//将返回的r转换为json
			if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
				fmt.Println(err)
				return
			} else {
				log.Printf("%s", string(rejson))
			}
		}

		//高轨巡视分析
		omInsAna := om.RunHoInsAnaInput{
			InsD:      10,
			InterVlue: 0.8,
			InsEW:     0,
		}
		if r, err := c.HoInsAnalysis(ctx, &omInsAna); err != nil {
			fmt.Println(err)
		} else {
			//将返回的r转换为json
			if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
				fmt.Println(err)
				return
			} else {
				log.Printf("%s", string(rejson))
			}
		}

		//高轨追击测试
		targetInput = []float64{42378000.0, 0.000, 0.0000, 00.0, 00.0, 10.0}
		chaseInput = []float64{42378000.0, 0.000, 0.0, 00.0, 00.0, 00.0}
		omChaseInput := om.RunHoChaseInput{
			ChaseEpoch:      "2022-12-15 00:00:00.000",
			IChaseInputType: 0,
			DChaseInputData: chaseInput,
			//
			TargetEpoch:      "2022-12-15 00:00:00.000",
			ItargetInputType: 0,
			DtargetInputData: targetInput,
			//
			ChaseSatMass:   1000.0,
			ChaseIsp:       300.0,
			ChaseAngleDiss: 0,
			ChaseStartTime: "2022-12-15 04:00:00.000",
			ChaseCircleNum: 1,
		}
		if r, err := c.HoChase(ctx, &omChaseInput); err != nil {
			fmt.Println(err)
		} else {
			//将返回的r转换为json
			if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
				fmt.Println(err)
				return
			} else {
				log.Printf("%s", string(rejson))
			}
		}
		//掠飞
		targetInput = []float64{42166300.0, 0.000, 0.0012902, 00.0, 90.7684, 255.507}
		flyby := []float64{42066300.0, 0.000, 0.0012902, 00.0, 91.8826, 313.507}
		omflybyInput := om.RunHoFlyByInput{
			FlyBEpoch:      "2023-05-19 04:00:00.000",
			IflyBInputType: 0,
			DflyBInputData: flyby,
			//
			TargetEpoch:      "2022-05-19 04:00:00.000",
			ItargetInputType: 0,
			DtargetInputData: targetInput,
			//
			FlyBSatMass: 1000.0,
			FlyBIsp:     300.0,
			FlyBydH:     20000,
			FlyByType:   0,
		}
		if r, err := c.HoFlyBy(ctx, &omflybyInput); err != nil {
			fmt.Println(err)
		} else {
			//将返回的r转换为json
			if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
				fmt.Println(err)
				return
			} else {
				log.Printf("%s", string(rejson))
			}
		}

		//直接追击
		DtargetInput := []float64{41329931.461381674,
			-8334976.752682849,
			-384083.7835558143,
			608.4043548670586,
			3013.976690095381,
			-3.9831574300718646}
		DchaseInput := []float64{33397948.072156046,
			-26235430.035024226,
			-1128339.797579026,
			1889.6384125812347,
			2410.104922866285,
			-61.9154097034231}
		omDChaseInput := om.RunDChaseInput{
			ChaseEpoch:      "2023-05-24 00:00:00.000",
			IChaseInputType: 1,
			DChaseInputData: DchaseInput,
			// 六根数，aei近地点幅角，升交点赤经，平近点角
			IChasePropagateType: 0,
			ChaseSatMass:        1000,
			ChaseIsp:            300,
			// 目标星参数
			TargetEpoch:      "2023-05-24 00:00:00.000",
			ItargetInputType: 1,
			DtargetInputData: DtargetInput,
			// 六根数，aei近地点幅角，升交点赤经，平近点角
			ItargetPropagateType: 0,
			// 追击开始时间
			DChaseStartTime: "2023-05-24 00:00:00.000",
			DChaseTime:      5000,
		}
		if r, err := c.DirectChase(ctx, &omDChaseInput); err != nil {
			fmt.Println(err)
		} else {
			//将返回的r转换为json
			if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
				fmt.Println(err)
				return
			} else {
				log.Printf("%s", string(rejson))
			}
		}

		//高轨追击分析
		omDchaseAna := om.RunDChaseAnaInput{
			ChaseEpoch:          "2023-05-24 00:00:00.000",
			IChaseInputType:     1,
			DChaseInputData:     DchaseInput,
			IChasePropagateType: 0,
			// 六根数，aei近地点幅角，升交点赤经，平近点角
			DChaseStartTime:    "2023-05-24 00:00:00.000",
			DChaseAnaStartTime: 0,
			DChaseAnaEndTime:   2.0 * 24 * 3600.0,
			AnaInterval:        30.0 * 60.0,
			// 目标星参数
			TargetEpoch:          "2023-05-24 00:00:00.000",
			ItargetInputType:     1,
			DtargetInputData:     DtargetInput,
			ItargetPropagateType: 0,
		}
		if r, err := c.DirectChaseAnalysis(ctx, &omDchaseAna); err != nil {
			fmt.Println(err)
		} else {
			//将返回的r转换为json
			if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
				fmt.Println(err)
				return
			} else {
				log.Printf("%s", string(rejson))
			}
		}

		//测试同步带，lambert可达范围
		runLambert := []float64{4.21657e+07,
			0.000382,
			0.35,
			0.0,
			0.0,
			90}
		runLambertR := om.RunLambertRachInput{
			ChaseEpoch:          "2023-04-14 00:00:00.000",
			IChaseInputType:     0,
			DChaseInputData:     runLambert,
			IChasePropagateType: 0,
			DeltaV:              300,
			NeedTime:            2.0 * 3600.0,
			LonInterval:         5,
		}
		if r, err := c.LambertChaseRach(ctx, &runLambertR); err != nil {
			fmt.Println(err)
		} else {
			//将返回的r转换为json
			if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
				fmt.Println(err)
				return
			} else {
				log.Printf("%s", string(rejson))
			}
		}*/
	// //测试相对坐标
	Ap := om.Vector{X: 7278140.000, Y: -0.000, Z: -0.000}
	Av := om.Vector{X: 0.000000, Y: 644.992543, Z: 7372.298497}
	Bp := om.Vector{X: 7263139.753, Y: -0.000, Z: 0.000}
	Bv := om.Vector{X: -0.000000, Y: 646.146086, Z: 7387.523992}
	//
	Ap1 := om.Vector{X: 7264599.000, Y: 38675.550, Z: 442063.562}
	Av1 := om.Vector{X: -451.210059, Y: 643.792576, Z: 7358.582820}
	Bp1 := om.Vector{X: 7249543.317, Y: 38744.571, Z: 442974.820}
	Bv1 := om.Vector{X: -453.072220, Y: 644.936520, Z: 7373.694764}

	rnRel := om.RunRelativeInput{}
	rnRel.Ap = append(rnRel.Ap, &Ap, &Ap1)
	rnRel.Av = append(rnRel.Av, &Av, &Av1)
	rnRel.Bp = append(rnRel.Bp, &Bp, &Bp1)
	rnRel.Bv = append(rnRel.Bv, &Bv, &Bv1)
	fmt.Println(rnRel.Ap)
	fmt.Println(rnRel.Av)
	fmt.Println(rnRel.Bp)
	fmt.Println(rnRel.Bv)
	if r, err := c.GetDERelMotion(ctx, &rnRel); err != nil {
		fmt.Println(err)
	} else {
		//将返回的r转换为json
		if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
			fmt.Println(err)
			return
		} else {
			log.Printf("数字地球参考，t0时刻J2000，需要转地固上球%s", string(rejson))
		}
	}

	if r, err := c.GetRelMotion(ctx, &rnRel); err != nil {
		fmt.Println(err)
	} else {
		//将返回的r转换为json
		if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
			fmt.Println(err)
			return
		} else {
			log.Printf("LVLH%s", string(rejson))
		}
	}
	//测试子星释放
	// FatherInputData := []float64{5132911.975,
	// 	3754383.824,
	// 	2038462.790,
	// 	-4942.264713,
	// 	5218.530143,
	// 	2833.431449,
	// }
	// ReleaseInfo1 := om.ReleaseInfo{Anglex: 0.0, Angley: 10.0, Anglez: 20.0, DeltaV: 10}
	// ReleaseInfo2 := om.ReleaseInfo{Anglex: 0.0, Angley: 10.0, Anglez: -20.0, DeltaV: 10}
	// ReleaseInfo3 := om.ReleaseInfo{Anglex: 60.0, Angley: 60.0, Anglez: 0.0, DeltaV: 10}

	// OmreleaseSubStar := om.RunReSubstarInput{
	// 	FatherEpoch:     "2023-06-15 04:10:00",
	// 	FatherInputData: FatherInputData,
	// }
	// OmreleaseSubStar.ReleaseInfos = append(OmreleaseSubStar.ReleaseInfos, &ReleaseInfo1,
	// 	&ReleaseInfo2, &ReleaseInfo3)
	// if r, err := c.ReleaseSubStar(ctx, &OmreleaseSubStar); err != nil {
	// 	fmt.Println(err)
	// } else {
	// 	//将返回的r转换为json
	// 	if rejson, err := json.MarshalIndent(r, "   ", " "); err != nil {
	// 		fmt.Println(err)
	// 		return
	// 	} else {
	// 		log.Printf("%s", string(rejson))
	// 	}
	// }

}
