//package com.mycompany.dobieracz001.Centrala;
//
///**
// * 
// *
// * @since 2017-09-12, 23:43:29
// * @author Grzegorz Brodowski
// */
//public class CentGlikol {
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
//using CarlosAg.ExcelXmlWriter;
//using System.Diagnostics;
//
//namespace WindowsFormsApplication1
//{
//    public partial class CentGlikol : Form
//    {
//        public bool OpenedWindow = false;
//
//        public CentGlikol()
//        {
//            InitializeComponent();
//            
//        }
//
//        public DataTable CreateDataTable()
//        {
//            DataTable ZestawienieUrzadzen = new DataTable();
//
//            DataColumn column;
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.Int32");
//            column.ColumnName = "id";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.String");
//            column.ColumnName = "Funkcja";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.String");
//            column.ColumnName = "Urządzenie";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.Int32");
//            column.ColumnName = "Ilość";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            //column = new DataColumn();
//            //column.DataType = Type.GetType("System.Int32");
//            //column.ColumnName = "AI";
//            //ZestawienieUrzadzen.Columns.Add(column);
//
//            //column = new DataColumn();
//            //column.DataType = Type.GetType("System.Int32");
//            //column.ColumnName = "DI";
//            //ZestawienieUrzadzen.Columns.Add(column);
//
//            //column = new DataColumn();
//            //column.DataType = Type.GetType("System.Int32");
//            //column.ColumnName = "AO";
//            //ZestawienieUrzadzen.Columns.Add(column);
//
//            //column = new DataColumn();
//            //column.DataType = Type.GetType("System.Int32");
//            //column.ColumnName = "DO";
//            //ZestawienieUrzadzen.Columns.Add(column);
//
//            return ZestawienieUrzadzen;
//        }
//
//        public DataTable CreateDataTable_syg()
//        {
//            DataTable ZestawienieUrzadzen = new DataTable();
//
//            DataColumn column;
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.Int32");
//            column.ColumnName = "id";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.String");
//            column.ColumnName = "Funkcja";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.Int32");
//            column.ColumnName = "AI";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.Int32");
//            column.ColumnName = "DI";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.Int32");
//            column.ColumnName = "AO";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            column = new DataColumn();
//            column.DataType = Type.GetType("System.Int32");
//            column.ColumnName = "DO";
//            ZestawienieUrzadzen.Columns.Add(column);
//
//            return ZestawienieUrzadzen;
//        }
//
//        private string[,] tab_centrali(string[,] urzadzenie, string nazwa)
//        {
//            int N = ilosc_urz_cent.value;
//            string[,] _tab_centrali = new string[4, N];
//            int _id = 0;
//            for (int j = 0; j <= 38; j++)
//            {
//                if (urzadzenie[2, j] != "" && urzadzenie[2, j] != null && urzadzenie[2, j] != "0")
//                {
//                    _id = _id + 1;
//                    _tab_centrali[0, _id - 1] = nazwa;
//                    _tab_centrali[1, _id - 1] = urzadzenie[1, j];
//                    _tab_centrali[2, _id - 1] = urzadzenie[2, j];
//                    _tab_centrali[3, _id - 1] = urzadzenie[3, j];
//                }
//            }
//            return _tab_centrali;
//        }
//
//        private string[,] syg_centrali(string[,] urzadzenie, string nazwa)
//        {
//            int N = ilosc_syg_cent.value;
//            string[,] _tab_centrali = new string[6, N];
//            int _id = 0;
//            for (int j = 0; j <= 50; j++)
//            {
//                int _AI = Convert.ToInt32(urzadzenie[4, j]);
//                int _DI = Convert.ToInt32(urzadzenie[5, j]);
//                int _AO = Convert.ToInt32(urzadzenie[6, j]);
//                int _DO = Convert.ToInt32(urzadzenie[7, j]);
//                int suma_syg = _AI + _DI + _AO + _DO;
//                if (suma_syg > 0 && urzadzenie[1, j] != "" && urzadzenie[1, j] != null && urzadzenie[1, j] != "brak")
//                {
//                    _id = _id + 1;
//                    _tab_centrali[0, _id - 1] = nazwa;
//                    _tab_centrali[1, _id - 1] = urzadzenie[3, j];
//                    _tab_centrali[2, _id - 1] = urzadzenie[4, j];
//                    _tab_centrali[3, _id - 1] = urzadzenie[5, j];
//                    _tab_centrali[4, _id - 1] = urzadzenie[6, j];
//                    _tab_centrali[5, _id - 1] = urzadzenie[7, j];
//                }
//            }
//            return _tab_centrali;
//        }
//
//        private void Clear_tab_cent()
//        {
//            for (int i = 0; i <= 38; i++)
//            {
//                tablica_urzadzen.tab_urz[1, i] = null;
//                tablica_urzadzen.tab_urz[2, i] = null;
//                tablica_urzadzen.tab_urz[4, i] = null;
//                tablica_urzadzen.tab_urz[5, i] = null;
//                tablica_urzadzen.tab_urz[6, i] = null;
//                tablica_urzadzen.tab_urz[7, i] = null;
//            }
//
//            for (int i = 43; i <= 50; i++)
//            {
//                tablica_urzadzen.tab_urz[1, i] = null;
//                tablica_urzadzen.tab_urz[2, i] = null;
//                tablica_urzadzen.tab_urz[4, i] = null;
//                tablica_urzadzen.tab_urz[5, i] = null;
//                tablica_urzadzen.tab_urz[6, i] = null;
//                tablica_urzadzen.tab_urz[7, i] = null;
//            }
//        }
//
//        public void AddDataToTable(string[,] urzadzenie, DataTable zestawienie)
//        {
//            DataRow row;
//            int _id = 0;
//            //int _AI = Convert.ToInt32(urzadzenie[4, i]);
//            for (int i = 0; i <= 38; i++)
//            {
//                if (urzadzenie[2, i] != "" && urzadzenie[2, i] != null && urzadzenie[2, i] != "0")
//                {
//                    _id = _id + 1;
//                    int _ilosc = Convert.ToInt32(urzadzenie[2, i]);
//                    row = zestawienie.NewRow();
//                    //row["Urządzenie"] = Guid.NewGuid().ToString();
//                    row["id"] = _id;
//                    row["Urządzenie"] = urzadzenie[1, i];
//                    row["Ilość"] = _ilosc;
//                    row["Funkcja"] = urzadzenie[3, i];
//                    //row["AI"] = urzadzenie[4, i];
//                    //row["DI"] = urzadzenie[5, i];
//                    //row["AO"] = urzadzenie[6, i];
//                    //row["DO"] = urzadzenie[7, i];
//                    zestawienie.Rows.Add(row);
//                    
//                    //dataGridView1.DataSource = zestawienie;
//                }
//            }
//            ilosc_urz_cent.value = _id;
//            dataGridView1.DataSource = zestawienie;
//            //dataGridView1.Columns["id"].Visible = false;
//            //dataGridView1.Columns["Funkcja"].FillWeight = 100;
//        }
//
//        public void AddDataToTable_syg(string[,] urzadzenie, DataTable zestawienie)
//        {
//            DataRow row;
//            int _id = 0;
//            for (int i = 0; i <= 50; i++)
//            {
//                int _AI = Convert.ToInt32(urzadzenie[4, i]);
//                int _DI = Convert.ToInt32(urzadzenie[5, i]);
//                int _AO = Convert.ToInt32(urzadzenie[6, i]);
//                int _DO = Convert.ToInt32(urzadzenie[7, i]);
//                int suma_syg = _AI + _DI + _AO + _DO;
//                if (suma_syg > 0 && urzadzenie[1, i] != "" && urzadzenie[1, i] != null && urzadzenie[1, i] != "brak")
//                {
//                    _id = _id + 1;
//                    int _ilosc = Convert.ToInt32(urzadzenie[2, i]);
//                    row = zestawienie.NewRow();
//                    //row["Urządzenie"] = Guid.NewGuid().ToString();
//                    row["id"] = _id;
//                    row["Funkcja"] = urzadzenie[3, i];
//                    row["AI"] = urzadzenie[4, i];
//                    row["DI"] = urzadzenie[5, i];
//                    row["AO"] = urzadzenie[6, i];
//                    row["DO"] = urzadzenie[7, i];
//                    zestawienie.Rows.Add(row);
//
//                    //dataGridView1.DataSource = zestawienie;
//                }
//            }
//            ilosc_syg_cent.value = _id;
//            sygnaly_dataGridView.DataSource = zestawienie;
//            //dataGridView1.Columns["id"].Visible = false;
//            //dataGridView1.Columns["Funkcja"].FillWeight = 100;
//        }
//
//
//
//
//
//
//        private void Wstecz_button_Click(object sender, EventArgs e)
//        {
//            Clear_tab_cent();
//            TypyCent T = new TypyCent();
//            T.MdiParent = this.MdiParent;
//            T.Show(); 
//        }
//
//        private void sprawdz_peryferia()
//        {
//            DataTable zestawienie = new DataTable();
//            DataTable zestawienie_syg = new DataTable();
//            zestawienie = CreateDataTable();
//            zestawienie_syg = CreateDataTable_syg();
//
//            //presostat filtra nawiewu
//            if (presostat_filtr_naw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("presostat_filtr_nawiew", "PA-930-83", "1", 0, 1, 0, 0);
//            }
//            if (presostat_filtr_naw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("presostat_filtr_nawiew", "brak", "0", 0, 0, 0, 0);
//            }
//            //presostat filtra wywiewu
//            if (presostat_filtr_wyw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("presostat_filtr_wywiew", "PA-930-83", "1", 0, 1, 0, 0);
//            }
//            if (presostat_filtr_wyw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("presostat_filtr_wywiew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //termostat przeciwzamrożeniowy
//            if (frost_checkBox.Checked == true)
//            {
//                string _ile = frost_numericUpDown.Value.ToString();
//                int _ileDI= Convert.ToInt32(frost_numericUpDown.Value);
//                tablica_urzadzen.DodajNowe("frost", "ST-FRE1", _ile, 0, _ileDI, 0, 0);
//            }
//            if (frost_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("frost", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //czujnik ciśnienia nawiew
//            if (cisnienie_naw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("cisnienie_nawiew", "PA-694-5000-V", "1", 1, 0, 0, 0);
//            }
//            if (cisnienie_naw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("cisnienie_nawiew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //czujnik temperatury nawiew
//            if (temp_naw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("temp_nawiew", "TT-522-B", "1", 1, 0, 0, 0);
//            }
//            if (temp_naw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("temp_nawiew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //czujnik wilgotności nawiew
//            if (wilg_naw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("wilg_nawiew", "RH-DT02/T-B", "1", 2, 0, 0, 0);
//            }
//            if (wilg_naw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("wilg_nawiew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //czujnik ciśnienia wyciąg
//            if (cisnienie_wyw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("cisnienie_wywiew", "PA-694-5000-V", "1", 1, 0, 0, 0);
//            }
//            if (cisnienie_wyw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("cisnienie_wywiew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //czujnik temperatury wyciąg
//            if (temp_wyw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("temp_wywiew", "TT-522-B", "1", 1, 0, 0, 0);
//            }
//            if (temp_wyw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("temp_wywiew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //czujnik wilgotności wyciąg
//            if (wilg_wyw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("wilg_wywiew", "RH-DT02/T-B", "1", 2, 0, 0, 0);
//            }
//            if (wilg_wyw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("wilg_wywiew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //czujnik temperatury zewnętrzny
//            if (temp_zew_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("temp_zew", "TT-531-B", "1", 1, 0, 0, 0);
//            }
//            if (temp_zew_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("temp_zew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //czujnik wilgotności i temperatury zewnętrzny
//            if (wilg_zew_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("wilg_zew", "RH-OS02-T-B", "1", 2, 0, 0, 0);
//            }
//            if (wilg_zew_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("wilg_zew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //czujnik temperatury wyrzutu
//            if (temp_wyrzut_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("temp_wyrzut", "TT-522-B", "1", 1, 0, 0, 0);
//            }
//            if (temp_wyrzut_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("temp_wyrzut", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //presostat wentylatora nawiewu
//            if (presostat_went_naw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("presostat_went_nawiew", "PA-930-85", "1", 0, 1, 0, 0);
//            }
//            if (presostat_went_naw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("presostat_went_nawiew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //presostat wentylatora wywiewu
//            if (presostat_went_wyw_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("presostat_went_wywiew", "PA-930-85", "1", 0, 1, 0, 0);
//            }
//            if (presostat_went_wyw_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("presostat_went_wywiew", "brak", "0", 0, 0, 0, 0);
//            }
//
//            //nawilżacz
//            if (nawilzacz_checkBox.Checked == true)
//            {
//                tablica_urzadzen.DodajNowe("syg_nawilzacz", "TAK", "1", 0, 1, 1, 1);
//            }
//            if (nawilzacz_checkBox.Checked == false)
//            {
//                tablica_urzadzen.DodajNowe("syg_nawilzacz", "brak", "0", 0, 0, 0, 0);
//            }
//
//
//            //dodanie do tabeli
//            AddDataToTable(tablica_urzadzen.tab_urz, zestawienie);
//            AddDataToTable_syg(tablica_urzadzen.tab_urz, zestawienie_syg);
//
//        }
//
//       
//
//        private void CentKrzyz_FormClosed(object sender, FormClosedEventArgs e)
//        {
//            OpenedWindow = false;
//        }
//
//        private void label1_Click(object sender, EventArgs e)
//        {
//           
//        }
//
//        private void button2_Click(object sender, EventArgs e)
//        {
//
//        }
//
//        private void pictureBox2_Click(object sender, EventArgs e)
//        {
//            Nagrzewnica_wstepna N1 = new Nagrzewnica_wstepna();
//            N1.Show(); 
//        }
//
//        private void silownik_wyw_button_Click(object sender, EventArgs e)
//        {
//            PrzepustnicaWywiew P2 = new PrzepustnicaWywiew();
//            P2.Show(); 
//        }
//
//        private void NameCent_textBox_TextChanged(object sender, EventArgs e)
//        {
//            if (NameCent_textBox.TextLength > 0)
//            {
//                Aktualizuj_button.Enabled = true;
//                peryferia_ON();
//            }
//
//            if (NameCent_textBox.TextLength == 0)
//            {
//                Aktualizuj_button.Enabled = false;
//                Dalej_button.Enabled = false;
//                peryferia_OFF();
//            }
//        }
//
//        private void peryferia_ON()
//        {
//            centrala_krzyzowa_panel.Visible = true;
//            centrala_disabled_panel.Visible = false;
//        }
//
//        private void peryferia_OFF()
//        {
//            centrala_krzyzowa_panel.Visible = false;
//            centrala_disabled_panel.Visible = true;
//        }
//
//        private void presostat_filtr_naw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (presostat_filtr_naw_checkBox.Checked == true)
//            {
//                presostat_filtr_nawiew_pictureBox.Visible = true;
//                presostat_filtr_nawiew_disabled_pictureBox.Visible = false;
//            }
//            if (presostat_filtr_naw_checkBox.Checked == false)
//            {
//                presostat_filtr_nawiew_pictureBox.Visible = false;
//                presostat_filtr_nawiew_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void silownik_naw_button_Click(object sender, EventArgs e)
//        {
//            PrzepustnicaNawiew P1 = new PrzepustnicaNawiew();
//            P1.Show(); 
//        }
//
//        private void nagrzewnica_wstepna_button_Click(object sender, EventArgs e)
//        {
//            Nagrzewnica_wstepna N1 = new Nagrzewnica_wstepna();
//            N1.Show(); 
//        }
//
//        private void chlodnica_button_Click(object sender, EventArgs e)
//        {
//            Chlodnica C = new Chlodnica();
//            C.Show();
//        }
//
//        private void presostat_filtr_wyw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (presostat_filtr_wyw_checkBox.Checked == true)
//            {
//                presostat_filtr_wywiew_pictureBox.Visible = true;
//                presostat_filtr_wywiew_disabled_pictureBox.Visible = false;
//            }
//            if (presostat_filtr_wyw_checkBox.Checked == false)
//            {
//                presostat_filtr_wywiew_pictureBox.Visible = false;
//                presostat_filtr_wywiew_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void nagrzewnica_wtorna_button_Click(object sender, EventArgs e)
//        {
//            Nagrzewnica_wtorna N2 = new Nagrzewnica_wtorna();
//            N2.Show(); 
//        }
//
//        private void silownik_krzyz_button_Click(object sender, EventArgs e)
//        {
//            PrzepustnicaKomora P3 = new PrzepustnicaKomora();
//            P3.Show(); 
//        }
//
//        private void frost_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (frost_checkBox.Checked == true)
//            {
//                frost_pictureBox.Visible = true;
//                frost_disabled_pictureBox.Visible = false;
//                frost_numericUpDown.Enabled = true;
//            }
//            if (frost_checkBox.Checked == false)
//            {
//                frost_pictureBox.Visible = false;
//                frost_disabled_pictureBox.Visible = true;
//                frost_numericUpDown.Enabled = false;
//            }
//        }
//
//        private void cisnienie_naw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (cisnienie_naw_checkBox.Checked == true)
//            {
//                cisnienie_naw_pictureBox.Visible = true;
//                cisnienie_naw_disabled_pictureBox.Visible = false;
//            }
//            if (cisnienie_naw_checkBox.Checked == false)
//            {
//                cisnienie_naw_pictureBox.Visible = false;
//                cisnienie_naw_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void temp_naw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (temp_naw_checkBox.Checked == true)
//            {
//                temp_naw_pictureBox.Visible = true;
//                temp_naw_disabled_pictureBox.Visible = false;
//            }
//            if (temp_naw_checkBox.Checked == false)
//            {
//                temp_naw_pictureBox.Visible = false;
//                temp_naw_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void wilg_naw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if(wilg_naw_checkBox.Checked)
//                temp_naw_checkBox.Checked = false;
//            if (wilg_naw_checkBox.Checked == true)
//            {
//                wilg_naw_pictureBox.Visible = true;
//                wilg_naw_disabled_pictureBox.Visible = false;
//            }
//            if (wilg_naw_checkBox.Checked == false)
//            {
//                wilg_naw_pictureBox.Visible = false;
//                wilg_naw_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void temp_zew_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (temp_zew_checkBox.Checked == true)
//            {
//                temp_zew_pictureBox.Visible = true;
//                temp_zew_disabled_pictureBox.Visible = false;
//            }
//            if (temp_zew_checkBox.Checked == false)
//            {
//                temp_zew_pictureBox.Visible = false;
//                temp_zew_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void wilg_zew_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (wilg_zew_checkBox.Checked)
//                temp_zew_checkBox.Checked = false;
//
//            if (wilg_zew_checkBox.Checked == true)
//            {
//                wilg_zew_pictureBox.Visible = true;
//                wilg_zew_disabled_pictureBox.Visible = false;
//            }
//            if (wilg_zew_checkBox.Checked == false)
//            {
//                wilg_zew_pictureBox.Visible = false;
//                wilg_zew_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void temp_wyrzut_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (temp_wyrzut_checkBox.Checked == true)
//            {
//                temp_wyrzut_pictureBox.Visible = true;
//                temp_wyrzut_disabled_pictureBox.Visible = false;
//            }
//            if (temp_wyrzut_checkBox.Checked == false)
//            {
//                temp_wyrzut_pictureBox.Visible = false;
//                temp_wyrzut_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void temp_wyw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (temp_wyw_checkBox.Checked == true)
//            {
//                temp_wyw_pictureBox.Visible = true;
//                temp_wyw_disabled_pictureBox.Visible = false;
//            }
//            if (temp_wyw_checkBox.Checked == false)
//            {
//                temp_wyw_pictureBox.Visible = false;
//                temp_wyw_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void cisnienie_wyw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (cisnienie_wyw_checkBox.Checked == true)
//            {
//                cisnienie_wyw_pictureBox.Visible = true;
//                cisnienie_wyw_disabled_pictureBox.Visible = false;
//            }
//            if (cisnienie_wyw_checkBox.Checked == false)
//            {
//                cisnienie_wyw_pictureBox.Visible = false;
//                cisnienie_wyw_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void wilg_wyw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (wilg_wyw_checkBox.Checked)
//                temp_wyw_checkBox.Checked = false;
//            if (wilg_wyw_checkBox.Checked == true)
//            {
//                wilg_wyw_pictureBox.Visible = true;
//                wilg_wyw_disabled_pictureBox.Visible = false;
//            }
//            if (wilg_wyw_checkBox.Checked == false)
//            {
//                wilg_wyw_pictureBox.Visible = false;
//                wilg_wyw_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void Dalej_button_Click(object sender, EventArgs e)
//        {
//           sprawdz_peryferia();
//           zestawienie_zbiorcze.dodaj_do_listy(tab_centrali(tablica_urzadzen.tab_urz, NameCent_textBox.Text));
//           sygnaly_zbiorcze.dodaj_do_listy(syg_centrali(tablica_urzadzen.tab_urz, NameCent_textBox.Text));
//           Clear_tab_cent();
//           TypyCent T = new TypyCent();
//           T.MdiParent = this.MdiParent;
//           T.Show();
//           //test();
//            //nagrzewnica_wstepna_button.BackgroundImage = WindowsFormsApplication1.Properties.Resources.nagrzewnica_disabled;
//            //ListaUrzadzen L = new ListaUrzadzen();
//            //L.MdiParent = this.MdiParent;
//            //L.Show(); 
//
//
//        }
//
//        private void presostat_went_wyw_disabled_pictureBox_Click(object sender, EventArgs e)
//        {
//            
//        }
//
//        private void presostat_went_wyw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (presostat_went_wyw_checkBox.Checked == true)
//            {
//                presostat_went_wyw_pictureBox.Visible = true;
//                presostat_went_wyw_disabled_pictureBox.Visible = false;
//            }
//            if (presostat_went_wyw_checkBox.Checked == false)
//            {
//                presostat_went_wyw_pictureBox.Visible = false;
//                presostat_went_wyw_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void presostat_went_naw_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (presostat_went_naw_checkBox.Checked == true)
//            {
//                presostat_went_naw_pictureBox.Visible = true;
//                presostat_went_naw_disabled_pictureBox.Visible = false;
//            }
//            if (presostat_went_naw_checkBox.Checked == false)
//            {
//                presostat_went_naw_pictureBox.Visible = false;
//                presostat_went_naw_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void went_naw_button_Click(object sender, EventArgs e)
//        {
//            Wentylator_nawiew W1 = new Wentylator_nawiew();
//            W1.Show(); 
//        }
//
//        private void Aktualizuj_button_Click(object sender, EventArgs e)
//        {
//            sprawdz_peryferia();
//            Dalej_button.Enabled = true;
//        }
//
//        private void nawilzacz_checkBox_CheckedChanged(object sender, EventArgs e)
//        {
//            if (nawilzacz_checkBox.Checked == true)
//            {
//                nawilzacz_pictureBox.Visible = true;
//                nawilzacz_disabled_pictureBox.Visible = false;
//            }
//            if (nawilzacz_checkBox.Checked == false)
//            {
//                nawilzacz_pictureBox.Visible = false;
//                nawilzacz_disabled_pictureBox.Visible = true;
//            }
//        }
//
//        private void went_wyw_button_Click(object sender, EventArgs e)
//        {
//            Wentylator_wywiew W1 = new Wentylator_wywiew();
//            W1.Show(); 
//        }
//
//        private void silownik_glikol_button_Click(object sender, EventArgs e)
//        {
//            Wymiennik_glikolowy P2 = new Wymiennik_glikolowy();
//            P2.Show();
//        }
//   
//    }
//}
