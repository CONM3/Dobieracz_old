//package com.mycompany.dobieracz001.Centrala;
//
///**
// * 
// *
// * @since 2017-09-12, 23:44:11
// * @author Grzegorz Brodowski
// */
//public class Chlodnica {
//
//}
//using System;
//using System.Collections.Generic;
//using System.ComponentModel;
//using System.Data;
//using System.Drawing;
//using System.Linq;
//using System.Text;
//using System.Windows.Forms;
//using System.Globalization;
//
//
//namespace WindowsFormsApplication1
//{
//    public partial class Chlodnica : Form
//    {
//        public Chlodnica()
//        {
//            InitializeComponent();
//        }
//
//        private void DisableALL()
//        {
//            typ_panel.Enabled = false;
//            budowa_panel.Enabled = false;
//            wodna_panel.Enabled = false;
//            elektryczna_panel.Enabled = false;
//            label1.Enabled = false;
//            label3.Enabled = false;
//        }
//
//        private void ClearAll()
//        {
//            moc_textBox.Clear();
//            zawor_pradowy_label.Text="";
//            moc_zaworu_label.Text = "";
//            Q_textBox.Clear();
//            T_textBox.Clear();
//            V_textBox.Clear();
//            p_textBox.Clear();
//            kvs_textBox.Clear();
//            zawor_label.Text = "";
//            silownik_label.Text = "";
//            kvs_label.Text = "";
//        }
//
//        private string przeplyw(string Q, string T)
//        {
//            double Q_d = Convert.ToDouble(Q);
//            double T_d = Convert.ToDouble(T);
//            double V;
//            V = (Q_d / T_d) * 0.86;
//            V = System.Math.Round(V, 2);
//            string V_str = V.ToString();
//            return V_str;       
//        }
//
//        private string kvs(string V, string p)
//        {
//            double V_d = Convert.ToDouble(V);
//            double p_d = Convert.ToDouble(p);
//            double kvs;
//            kvs = (10*V_d)/(System.Math.Sqrt(p_d));
//            kvs = System.Math.Round(kvs, 2);
//            string kvs_str = kvs.ToString();
//            return kvs_str;
//        }
//
//        private double dobrany_kvs_przelot(string kvs)
//        {
//            if (kvs_textBox.Text != "" && kvs_textBox.Text != null)
//            {
//                double wyb_kvs = 0;
//                double kvs_d = System.Math.Round(Convert.ToDouble(kvs), 2);
//                double kvs_d_up = System.Math.Round(1.1 * kvs_d, 2);
//                if (kvs_d >= 0 && kvs_d <= 0.27)
//                    wyb_kvs = 0.25;
//                if (kvs_d >= 0.29 && kvs_d <= 0.44)
//                    wyb_kvs = 0.4;
//                if (kvs_d >= 0.45 && kvs_d <= 0.69)
//                    wyb_kvs = 0.63;
//                if (kvs_d >= 0.70 && kvs_d <= 1.1)
//                    wyb_kvs = 1;
//                if (kvs_d >= 1.11 && kvs_d <= 1.76)
//                    wyb_kvs = 1.6;
//                if (kvs_d >= 1.77 && kvs_d <= 2.75)
//                    wyb_kvs = 2.5;
//                if (kvs_d >= 2.76 && kvs_d <= 4.4)
//                    wyb_kvs = 4;
//                if (kvs_d >= 4.41 && kvs_d <= 6.93)
//                    wyb_kvs = 6.3;
//                if (kvs_d >= 6.94 && kvs_d <= 9.46)
//                    wyb_kvs = 8.6;
//                if (kvs_d >= 9.47 && kvs_d <= 11)
//                    wyb_kvs = 10;
//                if (kvs_d >= 11.01 && kvs_d <= 17.6)
//                    wyb_kvs = 16;
//                if (kvs_d >= 17.61 && kvs_d <= 27.5)
//                    wyb_kvs = 25;
//                if (kvs_d >= 27.51 && kvs_d <= 44)
//                    wyb_kvs = 40;
//                if (kvs_d >= 44.01 && kvs_d <= 63.8)
//                    wyb_kvs = 58;
//                if (kvs_d >= 63.81 && kvs_d <= 99)
//                    wyb_kvs = 90;
//                if (kvs_d >= 99.01 && kvs_d <= 110)
//                    wyb_kvs = 100;
//                if (kvs_d >= 110.01 && kvs_d <= 159.5)
//                    wyb_kvs = 145;
//                if (kvs_d >= 159.51 && kvs_d <= 242)
//                    wyb_kvs = 220;
//                if (kvs_d >= 242.01 && kvs_d <= 352)
//                    wyb_kvs = 320;
//                if (kvs_d >= 352.01 && kvs_d <= 693)
//                    wyb_kvs = 630;
//                if (kvs_d >= 693.01 && kvs_d <= 1100)
//                    wyb_kvs = 1000;
//                if (kvs_d >= 1100.01)
//                    wyb_kvs = 9999;
//                return wyb_kvs;
//            }
//            return 0;
//        }
//
//        private double dobrany_kvs_trojdrog(string kvs)
//        {
//            if (kvs_textBox.Text != "" && kvs_textBox.Text != null)
//            {
//                double wyb_kvs = 0;
//                double kvs_d = System.Math.Round(Convert.ToDouble(kvs), 2);
//                double kvs_d_up = System.Math.Round(1.1 * kvs_d, 2);
//                if (kvs_d >= 0 && kvs_d <= 0.27)
//                    wyb_kvs = 0.25;
//                if (kvs_d >= 0.29 && kvs_d <= 0.44)
//                    wyb_kvs = 0.4;
//                if (kvs_d >= 0.45 && kvs_d <= 0.69)
//                    wyb_kvs = 0.63;
//                if (kvs_d >= 0.70 && kvs_d <= 1.1)
//                    wyb_kvs = 1;
//                if (kvs_d >= 1.11 && kvs_d <= 1.76)
//                    wyb_kvs = 1.6;
//                if (kvs_d >= 1.77 && kvs_d <= 2.75)
//                    wyb_kvs = 2.5;
//                if (kvs_d >= 2.76 && kvs_d <= 4.4)
//                    wyb_kvs = 4;
//                if (kvs_d >= 4.41 && kvs_d <= 6.93)
//                    wyb_kvs = 6.3;
//                if (kvs_d >= 6.94 && kvs_d <= 11)
//                    wyb_kvs = 10;
//                if (kvs_d >= 11.01 && kvs_d <= 17.6)
//                    wyb_kvs = 16;
//                if (kvs_d >= 17.61 && kvs_d <= 27.5)
//                    wyb_kvs = 25;
//                if (kvs_d >= 27.51 && kvs_d <= 44)
//                    wyb_kvs = 40;
//                if (kvs_d >= 44.01 && kvs_d <= 63.8)
//                    wyb_kvs = 58;
//                if (kvs_d >= 63.81 && kvs_d <= 99)
//                    wyb_kvs = 90;
//                if (kvs_d >= 99.01 && kvs_d <= 110)
//                    wyb_kvs = 100;
//                if (kvs_d >= 110.01 && kvs_d <= 159.5)
//                    wyb_kvs = 145;
//                if (kvs_d >= 159.51 && kvs_d <= 242)
//                    wyb_kvs = 220;
//                if (kvs_d >= 242.01 && kvs_d <= 352)
//                    wyb_kvs = 320;
//                if (kvs_d >= 352.01 && kvs_d <= 693)
//                    wyb_kvs = 630;
//                if (kvs_d >= 693.01 && kvs_d <= 1100)
//                    wyb_kvs = 1000;
//                if (kvs_d >= 1100.01)
//                    wyb_kvs = 9999;
//                return wyb_kvs;
//            }
//            return 0;
//        }
//        private double dobor_mocy(string moc)
//        {
//            if (moc_textBox.Text != "" && moc_textBox.Text != null)
//            {
//                double moc_d = System.Math.Round(Convert.ToDouble(moc), 2);
//                double wyb_moc=0;
//                if (moc_d >= 0 && moc_d <= 1.5)
//                    wyb_moc = 1.5;
//                if (moc_d > 1.5 && moc_d <= 3)
//                    wyb_moc = 3;
//                if (moc_d > 3 && moc_d <= 6)
//                    wyb_moc = 6;
//                if (moc_d > 6 && moc_d <= 12)
//                    wyb_moc = 12;
//                if (moc_d > 12 && moc_d <= 18)
//                    wyb_moc = 18;
//                if (moc_d > 18 && moc_d <= 27)
//                    wyb_moc = 27;
//                if (moc_d > 27 && moc_d <= 36)
//                    wyb_moc = 36;
//                if (moc_d > 36 && moc_d <= 54)
//                    wyb_moc = 54;
//                if (moc_d > 54 && moc_d <= 86)
//                    wyb_moc = 86;
//                if (moc_d > 86)
//                    wyb_moc = 99;
//                return wyb_moc;
//            }
//            return 0;
//        }
//
//        private void zawor_pradowy()
//        {
//            double moc_d = dobor_mocy(moc_textBox.Text);
//            int moc_int = Convert.ToInt32(moc_d*10);
//            switch (moc_int)
//            {
//                case 15:
//                    zawor_pradowy_label.Text = "RE-PR1-F-1.5";
//                    moc_zaworu_label.Text = "1,5kW";
//                    break;
//                case 30:
//                    zawor_pradowy_label.Text = "RE-PR1-F-3";
//                    moc_zaworu_label.Text = "3kW";
//                    break;
//                case 60:
//                    zawor_pradowy_label.Text = "RE-PR1-F-6";
//                    moc_zaworu_label.Text = "6kW";
//                    break;
//                case 120:
//                    zawor_pradowy_label.Text = "RE-PR3-DIN-12";
//                    moc_zaworu_label.Text = "12kW";
//                    break;
//                case 180:
//                    zawor_pradowy_label.Text = "RE-PR3-DIN-18";
//                    moc_zaworu_label.Text = "18kW";
//                    break;
//                case 270:
//                    zawor_pradowy_label.Text = "RE-PR3-E-27";
//                    moc_zaworu_label.Text = "27kW";
//                    break;
//                case 360:
//                    zawor_pradowy_label.Text = "RE-PR3-E-36";
//                    moc_zaworu_label.Text = "36kW";
//                    break;
//                case 540:
//                    zawor_pradowy_label.Text = "RE-PR3-E-54";
//                    moc_zaworu_label.Text = "54kW";
//                    break;
//                case 860:
//                    zawor_pradowy_label.Text = "RE-PR3-E-86";
//                    moc_zaworu_label.Text = "86kW";
//                    break;
//                case 990:
//                    zawor_pradowy_label.Text = "Moc nagrzewnicy jest za duża";
//                    moc_zaworu_label.Text = ">86kW";
//                    break;
//                default:
//                    zawor_pradowy_label.Text = "";
//                    moc_zaworu_label.Text = "";
//                    break;
//            }
//        }
//
//        private double dobrany_kvs_grzyb(string kvs)
//        {
//            if (kvs_textBox.Text != "" && kvs_textBox.Text != null)
//            {
//                double wyb_kvs = 0;
//                double kvs_d = System.Math.Round(Convert.ToDouble(kvs), 2);
//                double kvs_d_up = System.Math.Round(1.1 * kvs_d, 2);
//                if (kvs_d >= 0 && kvs_d <= 0.69)
//                    wyb_kvs = 0.63;
//                if (kvs_d >= 0.70 && kvs_d <= 1.1)
//                    wyb_kvs = 1;
//                if (kvs_d >= 1.11 && kvs_d <= 1.76)
//                    wyb_kvs = 1.6;
//                if (kvs_d >= 1.77 && kvs_d <= 2.75)
//                    wyb_kvs = 2.5;
//                if (kvs_d >= 2.76 && kvs_d <= 4.4)
//                    wyb_kvs = 4;
//                if (kvs_d >= 4.41 && kvs_d <= 6.93)
//                    wyb_kvs = 6.3;
//                if (kvs_d >= 6.94 && kvs_d <= 11)
//                    wyb_kvs = 10;
//                if (kvs_d >= 11.01 && kvs_d <= 17.6)
//                    wyb_kvs = 16;
//                if (kvs_d >= 17.61 && kvs_d <= 27.5)
//                    wyb_kvs = 25;
//                if (kvs_d >= 27.51 && kvs_d <= 44)
//                    wyb_kvs = 40;
//                if (kvs_d >= 44.01 && kvs_d <= 63.8)
//                    wyb_kvs = 58;
//                if (kvs_d >= 63.81 && kvs_d <= 99)
//                    wyb_kvs = 90;
//                if (kvs_d >= 99.01 && kvs_d <= 110)
//                    wyb_kvs = 100;
//                if (kvs_d >= 110.01 && kvs_d <= 159.5)
//                    wyb_kvs = 145;
//                if (kvs_d >= 159.51 && kvs_d <= 242)
//                    wyb_kvs = 220;
//                if (kvs_d >= 242.01 && kvs_d <= 352)
//                    wyb_kvs = 320;
//                if (kvs_d >= 352.01 && kvs_d <= 693)
//                    wyb_kvs = 630;
//                if (kvs_d >= 693.01 && kvs_d <= 1100)
//                    wyb_kvs = 1000;
//                if (kvs_d >= 1100.01)
//                    wyb_kvs = 9999;
//                return wyb_kvs;
//            }
//            return 0;
//        }
//
//        private void dobrany_zawor()
//        {
//            if (kulowy_radioButton.Checked)
//            {
//                if (trojdrogowy_radioButton.Checked)
//                {
//                    double kvs=dobrany_kvs_trojdrog(kvs_textBox.Text);
//                    string kvs_str = kvs.ToString();
//                    kvs_label.Text = kvs_str;
//                    int _kvs = Convert.ToInt32(kvs * 100);
//                    switch (_kvs)
//                    {
//                        case 25:
//                            zawor_label.Text = "R305K";
//                            silownik_label.Text = "TRD24-SR";
//                            break;
//                        case 40:
//                            zawor_label.Text = "R306K";
//                            silownik_label.Text = "TRD24-SR";
//                            break;
//                        case 63:
//                            zawor_label.Text = "R307K";
//                            silownik_label.Text = "TRD24-SR";
//                            break;
//                        case 100:
//                            zawor_label.Text = "R308K";
//                            silownik_label.Text = "TRD24-SR";
//                            break;
//                        case 160:
//                            zawor_label.Text = "R311";
//                            silownik_label.Text = "TR24-SR";
//                            break;
//                        case 250:
//                            zawor_label.Text = "R312";
//                            silownik_label.Text = "TR24-SR";
//                            break;
//                        case 400:
//                            zawor_label.Text = "R313";
//                            silownik_label.Text = "TR24-SR";
//                            break;
//                        case 630:
//                            zawor_label.Text = "R318";
//                            silownik_label.Text = "TR24-SR";
//                            break;
//                        case 1000:
//                            zawor_label.Text = "R323";
//                            silownik_label.Text = "LR24A-SR";
//                            break;
//                        case 1600:
//                            zawor_label.Text = "R331";
//                            silownik_label.Text = "NR24A-SR";
//                            break;
//                        case 2500:
//                            zawor_label.Text = "R348";
//                            silownik_label.Text = "NR24A-SR";
//                            break;
//                        case 4000:
//                            zawor_label.Text = "R349G";
//                            silownik_label.Text = "SR24A-SR";
//                            break;
//                        case 5800:
//                            zawor_label.Text = "R350G-A";
//                            silownik_label.Text = "SR24A-SR";
//                            break;
//                        case 9000:
//                            zawor_label.Text = "H779N";
//                            silownik_label.Text = "NV24-MFT";
//                            break;
//                        case 10000:
//                            zawor_label.Text = "H780N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 14500:
//                            zawor_label.Text = "H7100N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 22000:
//                            zawor_label.Text = "H7125N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 32000:
//                            zawor_label.Text = "H7150N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 63000:
//                            zawor_label.Text = "H7200W630-S7";
//                            silownik_label.Text = "GV12-24-SR-T";
//                            break;
//                        case 100000:
//                            zawor_label.Text = "H7250W1000-S7";
//                            silownik_label.Text = "GV12-24-SR-T";
//                            break;
//                        case 999900:
//                            zawor_label.Text = "Call to Belimo";
//                            silownik_label.Text = "Call to Belimo";
//                            kvs_label.Text = ">1000";
//                            break;
//                        default:
//                            zawor_label.Text = "";
//                            silownik_label.Text = "";
//                            kvs_label.Text = "";
//                            break;
//                    }
//                }
//
//                if (przelowtowy_radioButton.Checked)
//                {
//                    double kvs = dobrany_kvs_przelot(kvs_textBox.Text);
//                    string kvs_str = kvs.ToString();
//                    kvs_label.Text = kvs_str;
//                    int _kvs = Convert.ToInt32(kvs * 100);
//                    switch (_kvs)
//                    {
//                        case 25:
//                            zawor_label.Text = "R205K";
//                            silownik_label.Text = "TRD24-SR";
//                            break;
//                        case 40:
//                            zawor_label.Text = "R206K";
//                            silownik_label.Text = "TRD24-SR";
//                            break;
//                        case 63:
//                            zawor_label.Text = "R207K";
//                            silownik_label.Text = "TRD24-SR";
//                            break;
//                        case 100:
//                            zawor_label.Text = "R208K";
//                            silownik_label.Text = "TRD24-SR";
//                            break;
//                        case 160:
//                            zawor_label.Text = "R209K";
//                            silownik_label.Text = "TRD24-SR";
//                            break;
//                        case 250:
//                            zawor_label.Text = "R212";
//                            silownik_label.Text = "TR24-SR";
//                            break;
//                        case 400:
//                            zawor_label.Text = "R213";
//                            silownik_label.Text = "TR24-SR";
//                            break;
//                        case 630:
//                            zawor_label.Text = "R214";
//                            silownik_label.Text = "TR24-SR";
//                            break;
//                        case 860:
//                            zawor_label.Text = "R219";
//                            silownik_label.Text = "TR24-SR";
//                            break;
//                        case 1000:
//                            zawor_label.Text = "R223";
//                            silownik_label.Text = "LR24A-SR";
//                            break;
//                        case 1600:
//                            zawor_label.Text = "R224";
//                            silownik_label.Text = "LR24A-SR";
//                            break;
//                        case 2500:
//                            zawor_label.Text = "R239";
//                            silownik_label.Text = "NR24A-SR";
//                            break;
//                        case 4000:
//                            zawor_label.Text = "R249";
//                            silownik_label.Text = "NR24A-SR";
//                            break;
//                        case 5800:
//                            zawor_label.Text = "H664N";
//                            silownik_label.Text = "NV24-MFT";
//                            break;
//                        case 9000:
//                            zawor_label.Text = "H679N";
//                            silownik_label.Text = "NV24-MFT";
//                            break;
//                        case 10000:
//                            zawor_label.Text = "H680N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 14500:
//                            zawor_label.Text = "H6100N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 22000:
//                            zawor_label.Text = "H6125S";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 32000:
//                            zawor_label.Text = "H6150S";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 63000:
//                            zawor_label.Text = "H6200W630-S7";
//                            silownik_label.Text = "GV12-24-SR-T";
//                            break;
//                        case 100000:
//                            zawor_label.Text = "H6250W1000-S7";
//                            silownik_label.Text = "GV12-24-SR-T";
//                            break;
//                        case 999900:
//                            zawor_label.Text = "Call to Belimo";
//                            silownik_label.Text = "Call to Belimo";
//                            kvs_label.Text = ">1000";
//                            break;
//                        default:
//                            zawor_label.Text = "";
//                            silownik_label.Text = "";
//                            kvs_label.Text = "";
//                            break;
//                    }
//                }
//            }
//            if (grzyb_radioButton.Checked)
//            {
//                if (trojdrogowy_radioButton.Checked)
//                {
//                    double kvs = dobrany_kvs_grzyb(kvs_textBox.Text);
//                    string kvs_str = kvs.ToString();
//                    kvs_label.Text = kvs_str;
//                    int _kvs = Convert.ToInt32(kvs * 100);
//                    switch (_kvs)
//                    {
//                        case 63:
//                            zawor_label.Text = "H511B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 100:
//                            zawor_label.Text = "H512B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 160:
//                            zawor_label.Text = "H513B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 250:
//                            zawor_label.Text = "H514B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 400:
//                            zawor_label.Text = "H515B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 630:
//                            zawor_label.Text = "H520B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 1000:
//                            zawor_label.Text = "H525B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 1600:
//                            zawor_label.Text = "H532B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 2500:
//                            zawor_label.Text = "H540B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 4000:
//                            zawor_label.Text = "H550B";
//                            silownik_label.Text = "NV24-MFT";
//                            break;
//                        case 5800:
//                            zawor_label.Text = "H764N";
//                            silownik_label.Text = "NV24-MFT";
//                            break;
//                        case 9000:
//                            zawor_label.Text = "H779N";
//                            silownik_label.Text = "NV24-MFT";
//                            break;
//                        case 10000:
//                            zawor_label.Text = "H780N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 14500:
//                            zawor_label.Text = "H7100N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 22000:
//                            zawor_label.Text = "H7125N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 32000:
//                            zawor_label.Text = "H7150N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 63000:
//                            zawor_label.Text = "H7200W630-S7";
//                            silownik_label.Text = "GV12-24-SR-T";
//                            break;
//                        case 100000:
//                            zawor_label.Text = "H7250W1000-S7";
//                            silownik_label.Text = "GV12-24-SR-T";
//                            break;
//                        case 999900:
//                            zawor_label.Text = "Call to Belimo";
//                            silownik_label.Text = "Call to Belimo";
//                            kvs_label.Text = ">1000";
//                            break;
//                        default:
//                            zawor_label.Text = "";
//                            silownik_label.Text = "";
//                            kvs_label.Text = "";
//                            break;
//                    }
//                }
//
//                if (przelowtowy_radioButton.Checked)
//                {
//                    double kvs = dobrany_kvs_przelot(kvs_textBox.Text);
//                    string kvs_str = kvs.ToString();
//                    kvs_label.Text = kvs_str;
//                    int _kvs = Convert.ToInt32(kvs * 100);
//                    switch (_kvs)
//                    {
//                        case 63:
//                            zawor_label.Text = "H411B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 100:
//                            zawor_label.Text = "H412B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 160:
//                            zawor_label.Text = "H413B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 250:
//                            zawor_label.Text = "H414B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 400:
//                            zawor_label.Text = "H415B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 630:
//                            zawor_label.Text = "H420B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 1000:
//                            zawor_label.Text = "H425B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 1600:
//                            zawor_label.Text = "H432B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 2500:
//                            zawor_label.Text = "H440B";
//                            silownik_label.Text = "NVD24-SR";
//                            break;
//                        case 4000:
//                            zawor_label.Text = "H450B";
//                            silownik_label.Text = "NV24-MFT";
//                            break;
//                        case 5800:
//                            zawor_label.Text = "H664N";
//                            silownik_label.Text = "NV24-MFT";
//                            break;
//                        case 9000:
//                            zawor_label.Text = "H679N";
//                            silownik_label.Text = "NV24-MFT";
//                            break;
//                        case 10000:
//                            zawor_label.Text = "H680N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 14500:
//                            zawor_label.Text = "H6100N";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 22000:
//                            zawor_label.Text = "H6125S";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 32000:
//                            zawor_label.Text = "H6150S";
//                            silownik_label.Text = "AV24-MFT";
//                            break;
//                        case 63000:
//                            zawor_label.Text = "H6200W630-S7";
//                            silownik_label.Text = "GV12-24-SR-T";
//                            break;
//                        case 100000:
//                            zawor_label.Text = "H6250W1000-S7";
//                            silownik_label.Text = "GV12-24-SR-T";
//                            break;
//                        case 999900:
//                            zawor_label.Text = "Call to Belimo";
//                            silownik_label.Text = "Call to Belimo";
//                            kvs_label.Text = ">1000";
//                            break;
//                        default:
//                            zawor_label.Text = "";
//                            silownik_label.Text = "";
//                            kvs_label.Text = "";
//                            break;
//                    }
//                }
//            }
//        }
//
//        private void Nagrzewnica_wstepna_Load(object sender, EventArgs e)
//        {
//
//        }
//
//        private void wodna_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            typ_panel.Enabled = true;
//            budowa_panel.Enabled = true;
//            elektryczna_panel.Visible = false;
//            wodna_panel.Visible = true;
//            wodna_panel.Enabled = true;
//            label1.Enabled = true;
//            label3.Enabled = true;
//            ClearAll();
//        }
//
//        private void freonowa_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            DisableALL();
//            ClearAll();
//            zawor_label.Text = "brak";
//            silownik_label.Text = "brak";
//            zawor_nagrzewnica_wstepna.nazwa = "brak";
//            zawor_nagrzewnica_wstepna.ilosc = "1";
//            //typ_panel.Enabled = false;
//            //budowa_panel.Enabled = false;
//            //wodna_panel.Visible = false;
//            //elektryczna_panel.Visible = false;
//            //elektryczna_panel.Enabled = false;
//            //label1.Enabled = false;
//            //label3.Enabled = false;
//            //ClearAll();
//        }
//
//        private void brak_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            DisableALL();
//            ClearAll();
//            zawor_label.Text = "brak";
//            silownik_label.Text="brak";
//            zawor_nagrzewnica_wstepna.nazwa = "brak";
//            zawor_nagrzewnica_wstepna.ilosc = "1";
//        }
//
//        private void trojdrogowy_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            if (kvs_textBox.Text != "" && kvs_textBox.Text != null)
//                dobrany_zawor();
//        }
//
//        private void przelowtowy_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            if (kvs_textBox.Text != "" && kvs_textBox.Text != null)
//                dobrany_zawor();
//        }
//
//        private void kulowy_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            if (kvs_textBox.Text != "" && kvs_textBox.Text != null)
//                dobrany_zawor();
//        }
//
//        private void grzyb_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            if (kvs_textBox.Text != "" && kvs_textBox.Text != null)
//                dobrany_zawor();
//        }
//
//        private void moc_textBox_TextChanged(object sender, EventArgs e)
//        {
//            zawor_pradowy();
//            zawor_label.Text = "";
//            silownik_label.Text = "";
//        }
//
//        private void Q_textBox_TextChanged(object sender, EventArgs e)
//        {
//            try
//            {
//                double spr = Convert.ToDouble(Q_textBox.Text);
//                if ((T_textBox.Text != "") && (Q_textBox.Text != ""))
//                    V_textBox.Text = przeplyw(Q_textBox.Text, T_textBox.Text);
//            }
//            catch
//            {
//                Q_textBox.Clear();
//                V_textBox.Clear();
//            }
//        }
//
//        private void T_textBox_TextChanged(object sender, EventArgs e)
//        {
//            try
//            {
//                double spr = Convert.ToDouble(Q_textBox.Text);
//                if ((T_textBox.Text != "") && (Q_textBox.Text != ""))
//                    V_textBox.Text = przeplyw(Q_textBox.Text, T_textBox.Text);
//            }
//            catch
//            {
//                T_textBox.Clear();
//                V_textBox.Clear();
//            }
//        }
//
//        private void V_textBox_TextChanged(object sender, EventArgs e)
//        {
//            try
//            {
//                double spr = Convert.ToDouble(V_textBox.Text);
//                if ((p_textBox.Text != "") && (V_textBox.Text != ""))
//                {
//                    kvs_textBox.Text = kvs(V_textBox.Text, p_textBox.Text);
//                }
//            }
//            catch
//            {
//                V_textBox.Clear();
//                zawor_label.Text = "";
//                silownik_label.Text = "";
//                kvs_label.Text = "";
//            }
//            
//            
//        }
//
//        private void p_textBox_TextChanged(object sender, EventArgs e)
//        {
//            try
//            {
//                double spr = Convert.ToDouble(p_textBox.Text);
//                if ((p_textBox.Text != "") && (V_textBox.Text != ""))
//                {
//                    kvs_textBox.Text = kvs(V_textBox.Text, p_textBox.Text);
//                }
//            }
//            catch
//            {
//                p_textBox.Clear();
//                zawor_label.Text = "";
//                silownik_label.Text = "";
//                kvs_label.Text = "";
//            }
//        }
//
//        private void kvs_textBox_TextChanged(object sender, EventArgs e)
//        {
//            try
//            {
//                dobrany_zawor();
//                zawor_pradowy_label.Text = "";
//            }
//            catch
//            {
//                kvs_textBox.Clear();
//            }
//        }
//
//        private void OK_button_Click(object sender, EventArgs e)
//        {
//            if (zawor_label.Text == "" && zawor_pradowy_label.Text == "")
//                MessageBox.Show("Nie wybrano zaworu");
//
//            if (zawor_label.Text != "")
//            {
//                tablica_urzadzen.DodajNowe("zawor_chlodnica", zawor_label.Text, "1", 0, 0, 0, 0);
//                tablica_urzadzen.DodajNowe("silownik_chlodnica", silownik_label.Text, "1", 0, 0, 1, 0);
//                Close();
//            }
//
//            if (freonowa_radioButton.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("syg_freon", "tak", "1", 0, 0, 0, 1);
//                tablica_urzadzen.DodajNowe("zawor_chlodnica", "brak", "0", 0, 0, 0, 0);
//                tablica_urzadzen.DodajNowe("silownik_chlodnica", "brak", "0", 0, 0, 0, 0);
//            }
//
//            if (freonowa_radioButton.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("syg_freon", "nie", "1", 0, 0, 0, 0);
//            }
//            //if (zawor_pradowy_label.Text != "")
//            //{
//            //    tablica_urzadzen.DodajNowe("zawor_nagrzewnica_wstepna", zawor_pradowy_label.Text, "1");
//            //    Close();
//            //}
//
//            if (brak_radioButton.Checked)
//            {
//                tablica_urzadzen.DodajNowe("zawor_chlodnica", "brak", "0", 0, 0, 0, 0);
//                tablica_urzadzen.DodajNowe("silownik_chlodnica", "brak", "0", 0, 0, 0, 0);
//                Close();
//            }
//            
//        }
//
//        private void Cancel_button_Click(object sender, EventArgs e)
//        {
//            Close();
//        }
//
//        private void wodna_panel_Paint(object sender, PaintEventArgs e)
//        {
//
//        }
//
//        
//
//       
//
//        
//    }
//}
