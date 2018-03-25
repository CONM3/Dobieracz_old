//package com.mycompany.dobieracz001.Centrala;
//
///**
// * 
// *
// * @since 2017-09-12, 23:45:48
// * @author Grzegorz Brodowski
// */
//public class PrzepustnicaKomora {
//
//}
//
//using System;
//using System.Collections.Generic;
//using System.ComponentModel;
//using System.Data;
//using System.Drawing;
//using System.Linq;
//using System.Text;
//using System.Windows.Forms;
//using System.IO;
//
//
//
//
//
//namespace WindowsFormsApplication1
//{
//    public partial class PrzepustnicaKomora : Form
//    {
//        public string[,] SilownikNawiew_Tab = new string[2, 2]; //SilownikNawiew_Tab[0,0]-Siłownik, SilownikNawiew_Tab[1,0]- Akcesoria, SilownikNawiew_Tab[0,1]-ilość
//        public string silownik;
//        private int AI_akc;
//        private int DI_akc;
//        private int AO_akc;
//        private int DO_akc;
//        private int AI = 0;
//        private int DI;
//        private int AO;
//        private int DO;
//
//        public PrzepustnicaKomora()
//        {
//            
//            InitializeComponent();
//            ONOFF_bezSpr_Styk_panel.Visible = false;
//            ONOFF_bezSpr_bezStyk_panel.Visible = false;
//            ONOFF_ZeSpr_bezStyk_panel.Visible = false;
//            Analog_BezSpr_panel.Visible = false;
//            Analog_ZeSpr_panel.Visible = false;
//            
//            SprTypu();
//        }
//
//        public void SprTypu()
//        {
//            if (ON_OFF_radioButton.Checked)
//            {
//                if (ZeSprezna_radioButton.Checked)
//                {
//                    Akcesoria_panel.Enabled = false;
//                    if (ZeStykPom_radioButton.Checked)
//                    {
//                        ONOFF_ZeSpr_ZeStyk_panel.Visible = true;
//                        ONOFF_bezSpr_Styk_panel.Visible = false;
//                        ONOFF_bezSpr_bezStyk_panel.Visible = false;
//                        ONOFF_ZeSpr_bezStyk_panel.Visible = false;
//                        Analog_BezSpr_panel.Visible = false;
//                        Analog_ZeSpr_panel.Visible = false;
//                    }
//                }
//            }
//
//            if (ON_OFF_radioButton.Checked)
//            {
//                if (BezSprezyna_radioButton.Checked)
//                {
//                    Akcesoria_panel.Enabled = true;
//                    if (ZeStykPom_radioButton.Checked)
//                    {
//                        ONOFF_bezSpr_Styk_panel.Visible = true;
//                        ONOFF_ZeSpr_bezStyk_panel.Visible = false;
//                        ONOFF_bezSpr_bezStyk_panel.Visible = false;
//                        ONOFF_ZeSpr_ZeStyk_panel.Visible = false;
//                        Analog_BezSpr_panel.Visible = false;
//                        Analog_ZeSpr_panel.Visible = false;
//                    }
//                }
//            }
//
//            if (ON_OFF_radioButton.Checked)
//            {
//                if (BezSprezyna_radioButton.Checked)
//                {
//                    Akcesoria_panel.Enabled = true;
//                    if (BezStykPom_radioButton.Checked)
//                    {
//                        ONOFF_bezSpr_bezStyk_panel.Visible = true;
//                        ONOFF_ZeSpr_bezStyk_panel.Visible = false;
//                        ONOFF_bezSpr_Styk_panel.Visible = false;
//                        ONOFF_ZeSpr_ZeStyk_panel.Visible = false;
//                        Analog_BezSpr_panel.Visible = false;
//                        Analog_ZeSpr_panel.Visible = false;
//                    }
//                }
//
//            }
//
//            if (ON_OFF_radioButton.Checked)
//            {
//                if (ZeSprezna_radioButton.Checked)
//                {
//                    Akcesoria_panel.Enabled = false;
//                    if (BezStykPom_radioButton.Checked)
//                    {
//                        ONOFF_ZeSpr_bezStyk_panel.Visible=true;
//                        ONOFF_bezSpr_bezStyk_panel.Visible = false;
//                        ONOFF_bezSpr_Styk_panel.Visible = false;
//                        ONOFF_ZeSpr_ZeStyk_panel.Visible = false;
//                        Analog_BezSpr_panel.Visible = false;
//                        Analog_ZeSpr_panel.Visible = false;
//                    }
//                }
//
//            }
//
//            if (Analog_radioButton.Checked)
//            {
//                if (ZeSprezna_radioButton.Checked)
//                {
//                    Akcesoria_panel.Enabled = false;
//                    ONOFF_ZeSpr_bezStyk_panel.Visible = false;
//                    ONOFF_bezSpr_bezStyk_panel.Visible = false;
//                    ONOFF_bezSpr_Styk_panel.Visible = false;
//                    ONOFF_ZeSpr_ZeStyk_panel.Visible = false;
//                    Analog_BezSpr_panel.Visible = false;
//                    Analog_ZeSpr_panel.Visible = true;
//                }
//            }
//
//            if (Analog_radioButton.Checked)
//            {
//                if (BezSprezyna_radioButton.Checked)
//                {
//                    Akcesoria_panel.Enabled = true;
//                    ONOFF_ZeSpr_bezStyk_panel.Visible = false;
//                    ONOFF_bezSpr_bezStyk_panel.Visible = false;
//                    ONOFF_bezSpr_Styk_panel.Visible = false;
//                    ONOFF_ZeSpr_ZeStyk_panel.Visible = false;
//                    Analog_BezSpr_panel.Visible = true;
//                    Analog_ZeSpr_panel.Visible = false;
//                }
//            }
//        }
//
//        private void radioButton_ClearAll()
//        {
//            TF24_radioButton.Checked = false;
//            LF24_radioButton.Checked = false;
//            AF24_radioButton.Checked = false;
//            TF24S_radioButton.Checked = false;
//            LF24S_radioButton.Checked = false;
//            AF24S_radioButton.Checked = false;
//            LM24AS_radioButton.Checked = false;
//            NM24AS_radioButton.Checked = false;
//            SM24AS_radioButton.Checked = false;
//            LM24A_radioButton.Checked = false;
//            NM24A_radioButton.Checked = false;
//            SM24A_radioButton.Checked = false;
//            GM24A_radioButton.Checked = false;
//            TF24SR_radioButton.Checked = false;
//            LF24SR_radioButton.Checked = false;
//            AF24SR_radioButton.Checked = false;
//            LM24ASR_radioButton.Checked = false;
//            NM24ASR_radioButton.Checked = false;
//            SM24ASR_radioButton.Checked = false;
//            GM24ASR_radioButton.Checked = false;
//        }
//
//        private void paneleTyp_ON()
//        {
//            ONOFF_ZeSpr_ZeStyk_panel.Enabled = true;
//            ONOFF_bezSpr_Styk_panel.Enabled = true;
//            ONOFF_bezSpr_bezStyk_panel.Enabled = true;
//            ONOFF_ZeSpr_bezStyk_panel.Enabled = true;
//            Analog_ZeSpr_panel.Enabled = true;
//            Analog_BezSpr_panel.Enabled = true;
//            ONOFF_panel.Enabled = true;
//            Sprezyna_panel.Enabled = true;
//            Styki_panel.Enabled = true;
//        }
//
//        private void paneleTyp_OFF()
//        {
//            ONOFF_ZeSpr_ZeStyk_panel.Enabled = false;
//            ONOFF_bezSpr_Styk_panel.Enabled = false;
//            ONOFF_bezSpr_bezStyk_panel.Enabled = false;
//            ONOFF_ZeSpr_bezStyk_panel.Enabled = false;
//            Analog_ZeSpr_panel.Enabled = false;
//            Analog_BezSpr_panel.Enabled = false;
//            ONOFF_panel.Enabled = false;
//            Sprezyna_panel.Enabled = false;
//            Styki_panel.Enabled = false;
//        }
//
//        private void wpisTab(string silownik, decimal ilosc)
//        {
//   
//            string ilosc_str=ilosc.ToString();
//            
//            SilownikNawiew_Tab[0, 0] = silownik;
//            SilownikNawiew_Tab[0, 1] = ilosc_str;
//        }
//
//        private void Spr_akcesoria()
//        {
//            decimal _ilosc;
//            _ilosc=IloscAkcesoria_numericUpDown.Value;
//            int _ilosc_int = Convert.ToInt32(_ilosc);
//            AI_akc = 0;
//            AO_akc = 0;
//            DO_akc = 0;
//
//            string _ilosc_str = _ilosc.ToString();
//
//            if (S1A_checkBox.Checked)
//            {
//                SilownikNawiew_Tab[1, 0] = "S1A";
//                SilownikNawiew_Tab[1, 1] = _ilosc_str;
//                DI_akc = _ilosc_int;
//            }
//
//            if (S2A_checkBox.Checked)
//            {
//                SilownikNawiew_Tab[1, 0] = "S2A";
//                SilownikNawiew_Tab[1, 1] = _ilosc_str;
//                DI_akc = _ilosc_int*2;
//            }
//        }
//
//        private void sprWeWy()
//        {
//            decimal _ilosc;
//            _ilosc = IloscSilownikow_numericUpDown.Value;
//            int _ilosc_int = Convert.ToInt32(_ilosc);
//
//            if (ON_OFF_radioButton.Checked)
//            {
//                if (ZeStykPom_radioButton.Checked)
//                {
//                    AO = 0;
//                    DO = _ilosc_int;
//                    DI = _ilosc_int;
//                }
//            }
//
//            if (ON_OFF_radioButton.Checked)
//            {
//                if (BezStykPom_radioButton.Checked)
//                {
//                    AO = 0;
//                    DO = _ilosc_int;
//                    DI = 0;
//                }
//            }
//
//            if (Analog_radioButton.Checked)
//            {
//                AO = _ilosc_int;
//                DO = 0;
//                DI = 0;
//            }
//        }
//
//        //Klik obrazka = zaznaczony radio button 
//        private void pictureBox1_Click(object sender, EventArgs e)
//        {
//            TF24S_radioButton.Checked = true;
//        }
//
//        private void pictureBox3_Click(object sender, EventArgs e)
//        {
//            LF24S_radioButton.Checked = true;
//        }
//
//        private void pictureBox9_Click(object sender, EventArgs e)
//        {
//            LM24AS_radioButton.Checked = true;
//        }
//
//        private void pictureBox8_Click(object sender, EventArgs e)
//        {
//            NM24AS_radioButton.Checked = true;
//        }
//
//        private void pictureBox10_Click(object sender, EventArgs e)
//        {
//            SM24AS_radioButton.Checked = true;
//        }
//
//
//        private void pictureBox6_Click(object sender, EventArgs e)
//        {
//            TF24_radioButton.Checked = true;
//        }
//
//        private void pictureBox5_Click(object sender, EventArgs e)
//        {
//            LF24_radioButton.Checked = true;
//        }
//
//        private void pictureBox2_Click(object sender, EventArgs e)
//        {
//            AF24_radioButton.Checked = true;
//        }
//
//        private void pictureBox4_Click(object sender, EventArgs e)
//        {
//            AF24S_radioButton.Checked = true;
//        }
//
//        private void pictureBox14_Click(object sender, EventArgs e)
//        {
//            LM24A_radioButton.Checked = true;
//        }
//
//        private void pictureBox13_Click(object sender, EventArgs e)
//        {
//            NM24A_radioButton.Checked = true;
//        }
//
//        private void pictureBox11_Click(object sender, EventArgs e)
//        {
//            SM24A_radioButton.Checked = true;
//        }
//
//        private void pictureBox12_Click(object sender, EventArgs e)
//        {
//            GM24A_radioButton.Checked = true;
//        }
//
//        private void pictureBox20_Click(object sender, EventArgs e)
//        {
//            LM24ASR_radioButton.Checked = true;
//        }
//
//        private void pictureBox19_Click(object sender, EventArgs e)
//        {
//            NM24ASR_radioButton.Checked = true;
//        }
//
//        private void pictureBox17_Click(object sender, EventArgs e)
//        {
//            SM24ASR_radioButton.Checked = true;
//        }
//
//        private void pictureBox18_Click(object sender, EventArgs e)
//        {
//            GM24ASR_radioButton.Checked = true;
//        }
//        private void pictureBox15_Click(object sender, EventArgs e)
//        {
//            TF24SR_radioButton.Checked = true;
//        }
//
//        private void pictureBox16_Click(object sender, EventArgs e)
//        {
//            LF24SR_radioButton.Checked = true;
//        }
//
//        private void pictureBox7_Click(object sender, EventArgs e)
//        {
//            AF24SR_radioButton.Checked = true;
//        }
//        //Koniec klikania w obrazek
//
//
//        private void ON_OFF_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            SprTypu();
//            Styki_panel.Enabled = true;
//            radioButton_ClearAll();
//            SilownikNawiew_Tab[0,0] = "";
//            
//        }
//
//        private void ZeSprezna_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            SprTypu();
//            radioButton_ClearAll();
//            SilownikNawiew_Tab[0,0] = "";
//        }
//
//        private void ZeStykPom_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            SprTypu();
//           radioButton_ClearAll();
//            SilownikNawiew_Tab[0,0] = "";
//        }
//
//        private void Analog_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            SprTypu();
//            Styki_panel.Enabled = false;
//            radioButton_ClearAll();
//            SilownikNawiew_Tab[0,0] = "";
//        }
//
//        private void BezStykPom_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            SprTypu();
//            radioButton_ClearAll();
//            SilownikNawiew_Tab[0,0] = "";
//        }
//
//        private void BezSprezyna_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            SprTypu();
//            radioButton_ClearAll();
//            SilownikNawiew_Tab[0,0] = "";
//        }
//
//        private void PrzepustnicaNawiew_Load(object sender, EventArgs e)
//        {
//
//        }
//
//        private void S1A_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            S2A_checkBox.Checked = false;
//        }
//
//        private void S2A_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            S1A_checkBox.Checked = false;          
//        }
//
//        private void P140A_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            S1A_checkBox.Checked = false;
//            S2A_checkBox.Checked = false;
//           
//        }
//
//        private void IloscSilownikow_numericUpDown_ValueChanged(object sender, EventArgs e)
//        {
//            if (IloscSilownikow_numericUpDown.Value == 0)
//            {
//                paneleTyp_OFF();
//                Akcesoria_panel.Enabled = false;
//                silownik = "brak";
//
//            }
//
//            if (IloscSilownikow_numericUpDown.Value != 0)
//            {
//                paneleTyp_ON();
//                if(BezSprezyna_radioButton.Checked)
//                    Akcesoria_panel.Enabled = true;
//                    //SilownikNawiew_Tab[0, 1] = IloscSilownikow_numericUpDown.Value;
//            }
//
//        }
//
//        
//
//        private void LM24ASR_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik = "LM24A-SR";
//        }
//
//        private void NM24ASR_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="NM24A-SR";
//        }
//
//        private void SM24ASR_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="SM24A-SR";
//        }
//
//        private void GM24ASR_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="GM24A-SR";
//        }
//
//        private void TF24SR_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="TF24-SR";
//        }
//
//        private void LF24SR_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="LF24-SR";
//        }
//
//        private void AF24SR_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="AF24-SR";
//        }
//
//        private void TF24_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="TF24";
//        }
//
//        private void LF24_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="LF24";
//        }
//
//        private void AF24_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="AF24";
//        }
//
//        private void LM24A_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="LM24A";
//        }
//
//        private void NM24A_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="NM24A";
//        }
//
//        private void SM24A_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="SM24A";
//        }
//
//        private void GM24A_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="GM24A";
//        }
//
//        private void LM24AS_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="LM24A-S";
//        }
//
//        private void NM24AS_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="NM24A-S";
//        }
//
//        private void SM24AS_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="SM24A-S";
//        }
//
//        private void TF24S_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="TF24-S";
//        }
//
//        private void LF24S_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="LF24-S";
//        }
//
//        private void AF24S_radioButton_CheckedChanged(object sender, EventArgs e)
//        {
//            silownik ="AF24-S";
//        }
//
//        private void Cancel_button_Click(object sender, EventArgs e)
//        {
//            Close();
//        }
//
//        public void OK_button_Click(object sender, EventArgs e)
//        {
//            wpisTab(silownik, IloscSilownikow_numericUpDown.Value);
//            Spr_akcesoria();
//            sprWeWy();
//            tablica_urzadzen.DodajNowe("silownik_przepustnicy_komora", SilownikNawiew_Tab[0, 0], SilownikNawiew_Tab[0, 1], AI, DI, AO, DO);
//            tablica_urzadzen.DodajNowe("silownik_przepustnicy_komora_akc", SilownikNawiew_Tab[1, 0], SilownikNawiew_Tab[1, 1], AI_akc, DI_akc, AO_akc, DO_akc);
//            if (SilownikNawiew_Tab[0, 0] == null)
//                MessageBox.Show("Nie wybrano siłownika");
//            if(SilownikNawiew_Tab[0, 0] != null)
//            Close();
//        }
//
//      
//
//       
//
//        
//
//    
//        
//
//    }
//    
//}
