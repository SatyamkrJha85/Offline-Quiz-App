package com.computer.offlinecomputerquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.computer.offlinecomputerquiz.Model.HomeModel;
import com.computer.offlinecomputerquiz.Model.QuizModel;
import com.computer.offlinecomputerquiz.Model.SubModel;
import com.computer.offlinecomputerquiz.databinding.FragmentQuizBinding;

import java.util.ArrayList;
import java.util.Objects;


public class QuizFragment extends Fragment {

FragmentQuizBinding binding;
    ArrayList<QuizModel> list=new ArrayList<>();
    private int position=0;
    int right=0;
    private static String answer=null;
    int allQuestion;
    String listsize;
    String positionNo;
    QuizModel quizModel;
    String category,title;

    public QuizFragment() {
        // Required empty public constructor
    }
    public QuizFragment(String category,String title) {
        this.category=category;
        this.title=title;
    }



        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentQuizBinding.inflate(getLayoutInflater());

        loadQuestion();
        EnableOption();
        ClearOption();

        binding.nextBtn.setOnClickListener(v->{
            position++;
            loadQuestion();
            EnableOption();
            ClearOption();
            Checknexet();
        });


        return binding.getRoot();
    }

    private void Checknexet() {
        if(position==allQuestion){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new ResultFragment(right,allQuestion,category,title))
                    .commit();
            list.clear();
            position=0;
        }
    }

    private void ClearOption() {
        binding.option1Con.setBackgroundResource(R.drawable.option_bg);
        binding.option1Con.setTextColor(getContext().getColor(R.color.black));
        binding.option2Con.setBackgroundResource(R.drawable.option_bg);
        binding.option2Con.setTextColor(getContext().getColor(R.color.black));
        binding.option3Con.setBackgroundResource(R.drawable.option_bg);
        binding.option3Con.setTextColor(getContext().getColor(R.color.black));
        binding.option4Con.setBackgroundResource(R.drawable.option_bg);
        binding.option4Con.setTextColor(getContext().getColor(R.color.black));
        binding.nextBtn.setBackgroundResource(R.drawable.disable_btn);
    }

    private void EnableOption() {
        binding.option1Con.setEnabled(true);
        binding.option2Con.setEnabled(true);
        binding.option3Con.setEnabled(true);
        binding.option4Con.setEnabled(true);
        binding.nextBtn.setEnabled(false);
    }

    private void loadQuestion() {


        switch (title) {
            // For mathematics

            case "Test 1":
                list.add(new QuizModel("121 Divided by 11 is", "11", "10", "19", "18", "11"));
                list.add(new QuizModel("60 Times of 8 Equals to", "480", "300", "250", "400", "480"));
                list.add(new QuizModel("Find the Missing Term in Multiples of 6 : 6, 12, 18, 24, _, 36, 42, _ 54, 60", "32, 45", "30, 48", "24, 40", "25, 49", "30, 48"));
                list.add(new QuizModel("What is the Next Prime Number after 7 ?", "13", "12", "14", "11", "11"));
                list.add(new QuizModel("The Product of 131 × 0 × 300 × 4?", "11", "0", "46", "45", "0"));
                list.add(new QuizModel("Solve 3 + 6 × ( 5 + 4) ÷ 3 - 7 ?", "11", "16", "14", "15", "14"));
                list.add(new QuizModel("Solve 23 + 3 ÷ 3 ?", "24", "25", "26", "27", "24"));
                list.add(new QuizModel("What is 6% Equals to ?", "0.06", "0.6", "0.006", "0.0006", "0.06"));
                list.add(new QuizModel("How Many Years are there in a Decade?", "5 year", "10 year", "15 year", "20 year", "10 year"));
                list.add(new QuizModel("How Many Months Make a Century?", "12", "120", "1200", "12000", "1200"));
                list.add(new QuizModel("How Many Months Have 120 Days?", "2 months", "4 months", "11 months", "12 months", "4 months"));
                list.add(new QuizModel("How Many Sides are there in a Decagon?", "7", "8", "9", "10", "10"));
                list.add(new QuizModel("27 is a perfect cube. If true then what is the perfect cube of 27?", "9", "6", "3", "27", "3"));
                list.add(new QuizModel("Father of Trigonometry?", "Hipparchus", "Anasyan", "rehumbs", "reguys", "Hipparchus"));
                list.add(new QuizModel("Find the missing number in the series 5, 10, 17, _, 37, 50, 65, 82?", "26", "47", "78", "58", "26"));
                setup();
                break;

            case "Test 2":
                list.add(new QuizModel("Write the next number of the following Sequences 1,1, 2, 3, 5, 8, 13,_?", "21", "21", "45", "25", "21"));
                list.add(new QuizModel("Name of the Symbol ⊥ ?", "Ovel", "Circle", "Perpendicular", "Tengent", "Perpendicular"));
                list.add(new QuizModel("Which is the smallest Perfect Number?", "7", "6", "5", "8", "6"));
                list.add(new QuizModel("What is the next Prime Number after 13?", "17", "78", "32", "45", "17"));
                list.add(new QuizModel("Which is the only number that cannot be used as a Divisor?", "1", "4", "0", "7", "0"));
                list.add(new QuizModel("Which number is Known as Ramanujan-Hardy Number?", "784", "1729", "2354", "895", "1729"));
                list.add(new QuizModel("What is the name of the number system with base 2?", "Binary", "Decimal", "Octal", "Hecta", "Binary"));
                list.add(new QuizModel("How many seconds are there in one hour?", "3600 Seconds", "1600 Seconds", "5400 Seconds", "4700 Seconds", "3600 Seconds"));
                list.add(new QuizModel("Roman Number of 600?", "DD", "ER", "AS", "DC", "DC"));
                list.add(new QuizModel("How many sides are there in a Heptagon?", "9", "8", "4", "7", "7"));
                list.add(new QuizModel("Where did the “Magic Square” originate?", "Ancient China", " Ancient Japan", " Ancient U.K", " Ancient India", "Ancient China"));
                list.add(new QuizModel("What is the Line called which cuts a pair of Parallel lines?", "Horizontal", "Perpendicular", "Vertical", "Transversal", "Transversal"));
                list.add(new QuizModel("Calculate the Rate of Interest for a certain sum of money that becomes 5 times its principal Amount in 10 years?", "40%", "30%", "20%", "90%", "40%"));
                list.add(new QuizModel("The value of Pi?", " 3.14548", " 3.14178", " 3.14159", " 3.14185", " 3.14159"));
                list.add(new QuizModel("Value of Napier’s constant ‘e’?", "e ≈ 2.71828", "e ≈ 2.51828", "e ≈ 2.91828", "e ≈ 2.31828", "e ≈ 2.71828"));
                setup();
                break;

            case "Test 3":
                list.add(new QuizModel("Write the next number of the following Sequences 1, 1, 2, 3, 5, 8, 13,_?", "32", "75", "25", "21", "21"));
                list.add(new QuizModel("How many Zeros are there in One Billion?", "9", "2", "7", "5", "9"));
                list.add(new QuizModel("Which number is Known as the Ramanujan-Hardy Number?", "6521", "2145", "1729", "6523", "1729"));
                list.add(new QuizModel("Which number does not have a Reciprocal?", "5", "-1", "0", "1", "0"));
                list.add(new QuizModel("If Kara earns $80 in 8 hours, how many hours will it take her to earn $500?", "50 Hour", "15 Hour", "60 Hour", "500 Hour", "50 Hour"));
                list.add(new QuizModel("The sum of the greatest and smallest number of 3 digits is.", "1099", "5699", "1095", "2099", "1099"));
                list.add(new QuizModel("The sum of the first four prime numbers is ?", "12", "32", "65", "17", "17"));
                list.add(new QuizModel("Which of the following is the smallest 3 digits number exactly divisible by 6, 8 and 12?", "180", "120", "125", "520", "120"));
                list.add(new QuizModel("The greatest number of five digit which starts from 8 and with?", "87997", "12997", "89787", "89997", "89997"));
                list.add(new QuizModel("The sum of the greatest and smallest number of 3 digits is.", "7899", "5499", "1099", "3099", "1099"));
                list.add(new QuizModel("In the given number 890436, if you write 0 in place of 4, by how much the resulting numbe4r be less than the given number?", "254", "800", "300", "400", "400"));
                list.add(new QuizModel("What will be the result when seven times of 15 is subtracted from 119 ?", "14", "24", "32", "56", "14"));
                list.add(new QuizModel("7386038 is divisible by", "11", "14", "13", "12", "11"));
                list.add(new QuizModel("The prime numbers dividing 109 and leaving a remainder of 4 in each case are?", "2 and 9", "5 and 5", "1 and 7", "5 and 7", "5 and 7"));
                list.add(new QuizModel("The sum of first 20 odd natural numbers is equal to?", "200", "400", "300", "500", "400"));
                setup();
                break;

            case "Test 4":
                list.add(new QuizModel("In a class of 35 students, 7 students were absent on a particular day. What percentage of the students were absent?", "20%", "120%", "60%", "200%", "20%"));
                list.add(new QuizModel("The population of a city reduced from 25,000 to 24,500. Find the percentage decrease.", "12%", "23%", "28%", "2%", "2%"));
                list.add(new QuizModel("How much less is 28 km than 46.2 km?  ", "96.2 km ", "18.2 km ", "28.2 km ", "17.2 km ", "18.2 km "));
                list.add(new QuizModel("The population of a city reduced from 25,000 to 24,500. Find the percentage decrease.", "9 pm", "3 pm", "5 pm", "8 pm", "9 pm"));
                list.add(new QuizModel("If a/b = 2, what is the value of 4b/a ?", "2", "1", "4", "3", "2"));
                list.add(new QuizModel("The largest number that will divide 398,436 and 542 leaving remainders 7,11 and 15 respectively is ?", " 17", "38", "26", " 18", " 17"));
                list.add(new QuizModel("If b = 3, then any integer can be expressed as a = ?", "3q, 3q+ 1, 3q + 2", "3q", "4q+6q", "34q", " 3q, 3q+ 1, 3q + 2"));
                list.add(new QuizModel("Which of the following is not irrational?", "27√7", "(2 – √3)2", "(√2 -√3)(√2 + √3)", "(√2 + √3)2", "(√2 -√3)(√2 + √3)"));
                list.add(new QuizModel("HCF of 8, 9, 25 is", "1", "8", "6", "2", "1"));
                list.add(new QuizModel("Which of these numbers have only two factors, one and the number itself?", "52X45", "31X78", "37X1", "37X37", "37X1"));
                list.add(new QuizModel("Where did the “Magic Square” originate?", "Ancient China", " Ancient Japan", " Ancient U.K", " Ancient India", "Ancient China"));
                list.add(new QuizModel("What is the Line called which cuts a pair of Parallel lines?", "Horizontal", "Perpendicular", "Vertical", "Transversal", "Transversal"));
                list.add(new QuizModel("Calculate the Rate of Interest for a certain sum of money that becomes 5 times its principal Amount in 10 years?", "40%", "30%", "20%", "90%", "40%"));
                list.add(new QuizModel("The value of Pi?", " 3.14548", " 3.14178", " 3.14159", " 3.14185", " 3.14159"));
                list.add(new QuizModel("Value of Napier’s constant ‘e’?", "e ≈ 2.71828", "e ≈ 2.51828", "e ≈ 2.91828", "e ≈ 2.31828", "e ≈ 2.71828"));
                setup();
                break;

            case "Test 5":
                list.add(new QuizModel("3:50 times of 8 is equal to:", "300", "500", "900", "400", "400"));
                list.add(new QuizModel("The square root of 5 is:", "23.36", "7.246", "2.236", "5.236", "2.236"));
                list.add(new QuizModel("What must be added to each of the numerator and the denominator of the fraction 7/11 to make it equal to 3/4 ", "8", "5", "7", "8", "5"));
                list.add(new QuizModel("A figure with four equal sides is called?", "Square", "Tringle", "Rectangle", "Circle", "Square"));
                list.add(new QuizModel("One kilogram equals how many grams?", "1000 grams", "4000 grams", "8000 grams", "3000 grams", "2000 grams"));
                list.add(new QuizModel("In the given number 890436, if you write 0 in place of 4, by how much the resulting numbe4r be less than the given number?", "254", "800", "300", "400", "400"));
                list.add(new QuizModel("A square has all its angles equal to:", "90 degrees", "50 degrees", "70 degrees", "10 degrees", "90 degrees"));
                list.add(new QuizModel("The angles of a triangle are in the ratio 1: 2: 3. The greatest angle will be ?", "9", "7", "6", "2", "7"));
                list.add(new QuizModel("Look at this series: 36, 34, 30, 28, …, 22 What number should come to fill in the blank space", "3", "4", "5", "7", "7"));
                list.add(new QuizModel("Express 98 as a product of its primes ?", "2 × 7²", "6² × 8²", "7² × 9²", "3² × 8²", "2 × 7²"));
                list.add(new QuizModel("The largest number that will divide 398,436 and 542 leaving remainders 7,11 and 15 respectively is ?", " 17", "38", "26", " 18", " 17"));
                list.add(new QuizModel("If b = 3, then any integer can be expressed as a = ?", "3q, 3q+ 1, 3q + 2", "3q", "4q+6q", "34q", " 3q, 3q+ 1, 3q + 2"));
                list.add(new QuizModel("Which of the following is not irrational?", "27√7", "(2 – √3)2", "(√2 -√3)(√2 + √3)", "(√2 + √3)2", "(√2 -√3)(√2 + √3)"));
                list.add(new QuizModel("HCF of 8, 9, 25 is", "1", "8", "6", "2", "1"));
                list.add(new QuizModel("Which of these numbers have only two factors, one and the number itself?", "52X45", "31X78", "37X1", "37X37", "37X1"));
                setup();
                break;

            case "Test 6":
                list.add(new QuizModel("Which of these lies between 6.3 and 6.6?", "9.41", "3.41", "6.41", "5.41", "6.41"));
                list.add(new QuizModel("The simplest form of 16/24 is: ", "2/3", "5/6", "3/5", "7/5", "2/3"));
                list.add(new QuizModel("16÷ (4÷ 4) is equal to", "24", "65", "45", "16", "16"));
                list.add(new QuizModel(" 21.2×21.2-2×21.2×11.1+11.2×11.2 is equal to", "100", "500", "400", "120", "100"));
                list.add(new QuizModel("The sum and product of two numbers are 12 and 35, respectively. What will be the sum of their reciprocals?", "12/35", "82/45", "12/56", "78/35", "12/35"));
                list.add(new QuizModel("In the given number 890436, if you write 0 in place of 4, by how much the resulting numbe4r be less than the given number?", "254", "800", "300", "400", "400"));
                list.add(new QuizModel("What will be the result when seven times of 15 is subtracted from 119 ?", "14", "24", "32", "56", "14"));
                list.add(new QuizModel("7386038 is divisible by", "11", "14", "13", "12", "11"));
                list.add(new QuizModel("The prime numbers dividing 109 and leaving a remainder of 4 in each case are?", "2 and 9", "5 and 5", "1 and 7", "5 and 7", "5 and 7"));
                list.add(new QuizModel("The sum of first 20 odd natural numbers is equal to?", "200", "400", "300", "500", "400"));
                list.add(new QuizModel("Write the next number of the following Sequences 1, 1, 2, 3, 5, 8, 13,_?", "32", "75", "25", "21", "21"));
                list.add(new QuizModel("How many Zeros are there in One Billion?", "9", "2", "7", "5", "9"));
                list.add(new QuizModel("Which number is Known as the Ramanujan-Hardy Number?", "6521", "2145", "1729", "6523", "1729"));
                list.add(new QuizModel("Which number does not have a Reciprocal?", "5", "-1", "0", "1", "0"));
                list.add(new QuizModel("If Kara earns $80 in 8 hours, how many hours will it take her to earn $500?", "50 Hour", "15 Hour", "60 Hour", "500 Hour", "50 Hour"));
                setup();
                break;

            case "Test 7":
                list.add(new QuizModel("In the given number 890436, if you write 0 in place of 4, by how much the resulting numbe4r be less than the given number?", "254", "800", "300", "400", "400"));
                list.add(new QuizModel("What will be the result when seven times of 15 is subtracted from 119 ?", "14", "24", "32", "56", "14"));
                list.add(new QuizModel("7386038 is divisible by", "11", "14", "13", "12", "11"));
                list.add(new QuizModel("The prime numbers dividing 109 and leaving a remainder of 4 in each case are?", "2 and 9", "5 and 5", "1 and 7", "5 and 7", "5 and 7"));
                list.add(new QuizModel("The sum of first 20 odd natural numbers is equal to?", "200", "400", "300", "500", "400"));
                list.add(new QuizModel("Where did the “Magic Square” originate?", "Ancient China", " Ancient Japan", " Ancient U.K", " Ancient India", "Ancient China"));
                list.add(new QuizModel("What is the Line called which cuts a pair of Parallel lines?", "Horizontal", "Perpendicular", "Vertical", "Transversal", "Transversal"));
                list.add(new QuizModel("Calculate the Rate of Interest for a certain sum of money that becomes 5 times its principal Amount in 10 years?", "40%", "30%", "20%", "90%", "40%"));
                list.add(new QuizModel("The value of Pi?", " 3.14548", " 3.14178", " 3.14159", " 3.14185", " 3.14159"));
                list.add(new QuizModel("Value of Napier’s constant ‘e’?", "e ≈ 2.71828", "e ≈ 2.51828", "e ≈ 2.91828", "e ≈ 2.31828", "e ≈ 2.71828"));
                list.add(new QuizModel("The sum of the greatest and smallest number of 3 digits is.", "1099", "5699", "1095", "2099", "1099"));
                list.add(new QuizModel("The sum of the first four prime numbers is ?", "12", "32", "65", "17", "17"));
                list.add(new QuizModel("Which of the following is the smallest 3 digits number exactly divisible by 6, 8 and 12?", "180", "120", "125", "520", "120"));
                list.add(new QuizModel("The greatest number of five digit which starts from 8 and with?", "87997", "12997", "89787", "89997", "89997"));
                list.add(new QuizModel("The sum of the greatest and smallest number of 3 digits is.", "7899", "5499", "1099", "3099", "1099"));

                setup();
                break;

                // Math Section Ended Now



            // Physics Section start
            case "Physics Test 1":
                list.add(new QuizModel("What is the SI unit of mass?", "Kilogram", "Gram", "Pound", "Newton", "Kilogram"));
                list.add(new QuizModel("Which of these is a vector quantity?", "Speed", "Distance", "Mass", "Velocity", "Velocity"));
                list.add(new QuizModel("What does the law of conservation of energy state?", "Energy cannot be created or destroyed", "Energy can be created but not destroyed", "Energy can be destroyed but not created", "Energy can change into matter", "Energy cannot be created or destroyed"));
                list.add(new QuizModel("Which force holds the electrons in an atom?", "Gravitational force", "Electrostatic force", "Nuclear force", "Magnetic force", "Electrostatic force"));
                list.add(new QuizModel("What is the speed of light in a vacuum?", "300,000 meters per second", "150,000 meters per second", "600,000 meters per second", "900,000 meters per second", "300,000 meters per second"));
                list.add(new QuizModel("Which law of motion states that every action has an equal and opposite reaction?", "Newton's First Law", "Newton's Second Law", "Newton's Third Law", "Newton's Law of Gravitation", "Newton's Third Law"));
                list.add(new QuizModel("What is the unit of electric current?", "Volt", "Ohm", "Ampere", "Watt", "Ampere"));
                list.add(new QuizModel("Which type of energy is associated with the motion of particles?", "Kinetic energy", "Potential energy", "Mechanical energy", "Thermal energy", "Kinetic energy"));
                list.add(new QuizModel("What is the formula for calculating force?", "F = ma", "F = mg", "F = mv", "F = me", "F = ma"));
                list.add(new QuizModel("What is the main function of a concave lens?", "To magnify objects", "To reduce the size of objects", "To correct vision problems", "To reflect light", "To reduce the size of objects"));
                list.add(new QuizModel("What is the SI unit of electric charge?", "Volt", "Ampere", "Ohm", "Coulomb", "Coulomb"));
                list.add(new QuizModel("Which law of thermodynamics states that energy cannot be created or destroyed, only transferred or converted?", "Zeroth law of thermodynamics", "First law of thermodynamics", "Second law of thermodynamics", "Third law of thermodynamics", "First law of thermodynamics"));
                list.add(new QuizModel("What is the force of gravity on an object with a mass of 10 kg?", "1 N", "5 N", "10 N", "50 N", "10 N"));
                list.add(new QuizModel("What is the SI unit of power?", "Joule", "Watt", "Volt", "Ampere", "Watt"));
                list.add(new QuizModel("Which of the following is not a fundamental particle?", "Electron", "Proton", "Neutron", "Molecule", "Molecule"));

                setup();
                break;

            case "Physics Test 2":
                list.add(new QuizModel("What is the process by which a liquid changes into a gas at its surface?", "Condensation", "Vaporization", "Melting", "Sublimation", "Vaporization"));
                list.add(new QuizModel("What is the phenomenon where a wave bends as it passes from one medium to another?", "Reflection", "Refraction", "Interference", "Diffraction", "Refraction"));
                list.add(new QuizModel("Which gas is responsible for the green color of plants?", "Oxygen", "Nitrogen", "Carbon dioxide", "Chlorophyll", "Chlorophyll"));
                list.add(new QuizModel("What is the SI unit of frequency?", "Hertz", "Watt", "Ohm", "Joule", "Hertz"));
                list.add(new QuizModel("What is the acceleration due to gravity on Earth's surface?", "5 m/s²", "10 m/s²", "15 m/s²", "20 m/s²", "10 m/s²"));
                list.add(new QuizModel("What is the phenomenon where an object appears to be a different color depending on the angle of view?", "Refraction", "Dispersion", "Interference", "Diffraction", "Dispersion"));
                list.add(new QuizModel("Which instrument is used to measure atmospheric pressure?", "Barometer", "Thermometer", "Hygrometer", "Manometer", "Barometer"));
                list.add(new QuizModel("What is the unit of electrical resistance?", "Ampere", "Volt", "Ohm", "Watt", "Ohm"));
                list.add(new QuizModel("Which of these is a primary color of light?", "Red", "Blue", "Green", "Yellow", "Green"));
                list.add(new QuizModel("What is the process by which heat is transferred through direct contact of particles?", "Conduction", "Convection", "Radiation", "Insulation", "Conduction"));
                list.add(new QuizModel("What is the law that states that the total electric charge in a closed system is constant?", "Coulomb's Law", "Gauss's Law", "Ohm's Law", "Conservation of Charge", "Conservation of Charge"));
                list.add(new QuizModel("What is the SI unit of capacitance?", "Volt", "Ohm", "Ampere", "Farad", "Farad"));
                list.add(new QuizModel("What is the SI unit of magnetic flux?", "Weber", "Tesla", "Henry", "Coulomb", "Weber"));
                list.add(new QuizModel("What is the phenomenon where a sound wave bounces off a surface?", "Reflection", "Refraction", "Interference", "Diffraction", "Reflection"));
                list.add(new QuizModel("What is the speed of sound in air at room temperature (approximately)?", "100 m/s", "343 m/s", "500 m/s", "1000 m/s", "343 m/s"));

                setup();
                break;

            case "Physics Test 3":
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and volume of a gas at constant temperature?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Boyle's Law"));
                list.add(new QuizModel("What is the process by which a substance changes from a gas to a liquid?", "Condensation", "Vaporization", "Melting", "Sublimation", "Condensation"));
                list.add(new QuizModel("What is the SI unit of magnetic field strength?", "Weber", "Tesla", "Henry", "Coulomb", "Tesla"));
                list.add(new QuizModel("Which type of mirror can form both real and virtual images?", "Convex mirror", "Concave mirror", "Plane mirror", "Spherical mirror", "Spherical mirror"));
                list.add(new QuizModel("What is the energy of motion called?", "Potential energy", "Thermal energy", "Kinetic energy", "Mechanical energy", "Kinetic energy"));
                list.add(new QuizModel("What is the process by which a solid changes directly into a gas without passing through the liquid state?", "Condensation", "Vaporization", "Melting", "Sublimation", "Sublimation"));
                list.add(new QuizModel("Which of these is a measure of how hot or cold an object is?", "Temperature", "Pressure", "Volume", "Density", "Temperature"));
                list.add(new QuizModel("What is the law that states that the total pressure of a gas mixture is the sum of the partial pressures of its individual gases?", "Boyle's Law", "Charles's Law", "Dalton's Law", "Gay-Lussac's Law", "Dalton's Law"));
                list.add(new QuizModel("What is the SI unit of inductance?", "Henry", "Tesla", "Ampere", "Ohm", "Henry"));
                list.add(new QuizModel("What is the phenomenon where two waves combine to form a single wave with a larger amplitude?", "Reflection", "Refraction", "Interference", "Diffraction", "Interference"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and temperature of a gas at constant volume?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Gay-Lussac's Law"));
                list.add(new QuizModel("What is the SI unit of luminous intensity?", "Lumen", "Candela", "Lux", "Watt", "Candela"));
                list.add(new QuizModel("Which of these is not a type of electromagnetic radiation?", "X-rays", "Ultraviolet", "Infrared", "Sonar", "Sonar"));
                list.add(new QuizModel("What is the law that describes the relationship between the volume and temperature of a gas at constant pressure?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Charles's Law"));
                list.add(new QuizModel("What is the process by which a gas changes into a liquid?", "Condensation", "Vaporization", "Melting", "Sublimation", "Condensation"));
                setup();
                break;

            case "Physics Test 4":
                list.add(new QuizModel("What is the SI unit of electric potential difference?", "Volt", "Ohm", "Ampere", "Watt", "Volt"));
                list.add(new QuizModel("What is the phenomenon where a wave bends as it passes through an opening or around an obstacle?", "Reflection", "Refraction", "Interference", "Diffraction", "Diffraction"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and volume of a gas at constant temperature and moles of gas?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Avogadro's Law"));
                list.add(new QuizModel("What is the SI unit of electric conductance?", "Ohm", "Siemens", "Ampere", "Watt", "Siemens"));
                list.add(new QuizModel("Which type of lens is used to correct nearsightedness?", "Concave lens", "Convex lens", "Diverging lens", "Plano-concave lens", "Concave lens"));
                list.add(new QuizModel("What is the phenomenon where light is separated into its component colors due to its different wavelengths?", "Reflection", "Refraction", "Interference", "Dispersion", "Dispersion"));
                list.add(new QuizModel("What is the law that describes the relationship between the volume and moles of gas at constant temperature and pressure?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Avogadro's Law"));
                list.add(new QuizModel("What is the SI unit of electric capacitance?", "Volt", "Ohm", "Ampere", "Farad", "Farad"));
                list.add(new QuizModel("Which of these is a measure of the amount of matter in an object?", "Weight", "Mass", "Volume", "Density", "Mass"));
                list.add(new QuizModel("What is the law that states that the pressure of a gas is inversely proportional to its volume at constant temperature?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Boyle's Law"));
                list.add(new QuizModel("What is the phenomenon where a wave changes speed and direction as it passes from one medium to another?", "Reflection", "Refraction", "Interference", "Diffraction", "Refraction"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and temperature of a gas at constant volume?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Gay-Lussac's Law"));
                list.add(new QuizModel("What is the SI unit of magnetic permeability?", "Weber", "Tesla", "Henry", "Hertz", "Henry"));
                list.add(new QuizModel("Which type of mirror always forms virtual, upright, and diminished images?", "Convex mirror", "Concave mirror", "Plane mirror", "Spherical mirror", "Convex mirror"));
                list.add(new QuizModel("What is the energy stored in an object due to its position or height?", "Kinetic energy", "Potential energy", "Thermal energy", "Mechanical energy", "Potential energy"));

                setup();
                break;

            case "Physics Test 5":
                list.add(new QuizModel("What is the law that describes the relationship between the volume and moles of gas at constant pressure and temperature?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Avogadro's Law"));
                list.add(new QuizModel("What is the SI unit of electric charge flow?", "Ampere", "Volt", "Ohm", "Coulomb", "Ampere"));
                list.add(new QuizModel("What is the phenomenon where two waves cancel each other out when they overlap?", "Reflection", "Refraction", "Interference", "Diffraction", "Interference"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and temperature of a gas at constant volume?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Gay-Lussac's Law"));
                list.add(new QuizModel("What is the SI unit of magnetic field?", "Weber", "Tesla", "Henry", "Coulomb", "Tesla"));
                list.add(new QuizModel("Which type of lens is used to correct farsightedness?", "Concave lens", "Convex lens", "Diverging lens", "Plano-convex lens", "Convex lens"));
                list.add(new QuizModel("What is the phenomenon where a wave spreads out as it passes through a small opening?", "Reflection", "Refraction", "Interference", "Diffraction", "Diffraction"));
                list.add(new QuizModel("What is the law that describes the relationship between the volume and pressure of a gas at constant temperature and moles of gas?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Boyle's Law"));
                list.add(new QuizModel("What is the SI unit of electric resistance?", "Ampere", "Volt", "Ohm", "Watt", "Ohm"));
                list.add(new QuizModel("Which of these is a measure of the gravitational force acting on an object?", "Weight", "Mass", "Volume", "Density", "Weight"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and temperature of a gas at constant volume?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Gay-Lussac's Law"));
                list.add(new QuizModel("What is the SI unit of magnetic flux density?", "Weber", "Tesla", "Henry", "Coulomb", "Tesla"));
                list.add(new QuizModel("What is the phenomenon where light waves change direction as they pass from one medium to another?", "Reflection", "Refraction", "Interference", "Diffraction", "Refraction"));
                list.add(new QuizModel("What is the process by which a liquid changes into a gas below its boiling point?", "Condensation", "Vaporization", "Melting", "Sublimation", "Vaporization"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and temperature of a gas at constant volume?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Gay-Lussac's Law"));
                setup();
                break;

            case "Physics Test 6":
                list.add(new QuizModel("What is the SI unit of electric current flow?", "Volt", "Ohm", "Ampere", "Watt", "Ampere"));
                list.add(new QuizModel("Which of these is a measure of how tightly packed the particles in a substance are?", "Temperature", "Pressure", "Volume", "Density", "Density"));
                list.add(new QuizModel("What is the law that describes the relationship between the volume and moles of gas at constant pressure and temperature?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Avogadro's Law"));
                list.add(new QuizModel("What is the SI unit of electric potential?", "Volt", "Ohm", "Ampere", "Watt", "Volt"));
                list.add(new QuizModel("Which type of wave does not require a medium to propagate?", "Transverse wave", "Longitudinal wave", "Mechanical wave", "Electromagnetic wave", "Electromagnetic wave"));
                list.add(new QuizModel("What is the process by which a liquid changes into a solid?", "Condensation", "Vaporization", "Melting", "Freezing", "Freezing"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and temperature of a gas at constant volume?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Gay-Lussac's Law"));
                list.add(new QuizModel("What is the SI unit of electric charge flow rate?", "Ampere", "Volt", "Ohm", "Coulomb", "Ampere"));
                list.add(new QuizModel("Which of these is a measure of the force exerted by gravity on an object?", "Weight", "Mass", "Volume", "Density", "Weight"));
                list.add(new QuizModel("What is the law that describes the relationship between the volume and moles of gas at constant pressure and temperature?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Avogadro's Law"));
                list.add(new QuizModel("What is the SI unit of magnetic field strength?", "Weber", "Tesla", "Henry", "Coulomb", "Tesla"));
                list.add(new QuizModel("Which type of lens is used to correct astigmatism?", "Concave lens", "Convex lens", "Cylindrical lens", "Spherical lens", "Cylindrical lens"));
                list.add(new QuizModel("What is the phenomenon where light waves combine to form a single wave with a larger amplitude?", "Reflection", "Refraction", "Interference", "Diffraction", "Interference"));
                list.add(new QuizModel("What is the law that describes the relationship between the volume and temperature of a gas at constant pressure?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Charles's Law"));
                list.add(new QuizModel("What is the SI unit of luminous flux?", "Lumen", "Candela", "Lux", "Watt", "Lumen"));

                setup();
                break;

            case "Physics Test 7":
                list.add(new QuizModel("Which of these is a type of electromagnetic radiation that has the longest wavelength?", "Visible light", "Ultraviolet", "Infrared", "Microwave", "Microwave"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and temperature of a gas at constant volume?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Gay-Lussac's Law"));
                list.add(new QuizModel("What is the SI unit of electric charge?", "Volt", "Ampere", "Ohm", "Coulomb", "Coulomb"));
                list.add(new QuizModel("Which of these is a measure of the amount of space occupied by an object?", "Weight", "Mass", "Volume", "Density", "Volume"));
                list.add(new QuizModel("What is the law that describes the relationship between the volume and moles of gas at constant pressure and temperature?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Avogadro's Law"));
                list.add(new QuizModel("What is the SI unit of electric conductance?", "Ohm", "Siemens", "Ampere", "Watt", "Siemens"));
                list.add(new QuizModel("Which of these is a measure of the pressure exerted by a fluid?", "Weight", "Mass", "Volume", "Pressure", "Pressure"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and temperature of a gas at constant volume?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Gay-Lussac's Law"));
                list.add(new QuizModel("What is the SI unit of magnetic flux density?","Weber", "Tesla", "Henry", "Coulomb", "Tesla"));
                list.add(new QuizModel("Which type of lens is used to correct presbyopia?", "Concave lens", "Convex lens", "Diverging lens", "Bifocal lens", "Bifocal lens"));
                list.add(new QuizModel("What is the phenomenon where light waves change direction as they pass through a medium with a different refractive index?", "Reflection", "Refraction", "Interference", "Diffraction", "Refraction"));
                list.add(new QuizModel("What is the law that describes the relationship between the pressure and temperature of a gas at constant volume?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Gay-Lussac's Law"));
                list.add(new QuizModel("What is the SI unit of luminous flux?", "Lumen", "Candela", "Lux", "Watt", "Lumen"));
                list.add(new QuizModel("Which of these is a type of electromagnetic radiation that has the shortest wavelength?", "Visible light", "Ultraviolet", "Infrared", "X-rays", "X-rays"));
                list.add(new QuizModel("What is the law that describes the relationship between the volume and temperature of a gas at constant pressure?", "Boyle's Law", "Charles's Law", "Avogadro's Law", "Gay-Lussac's Law", "Charles's Law"));

                setup();
                break;



                // Physics section end

            // Computer Start

            case "Computer Test 1":
                list.add(new QuizModel("What does CPU stand for?", "Central Programming Unit", "Computer Personal Unit", "Central Processing Unit", "Central Process Unit", "Central Processing Unit"));
                list.add(new QuizModel("Which programming language is known as the 'father of all languages'¬¬¬¬¬?", "Java", "Python", "C", "Fortran", "C"));
                list.add(new QuizModel("What does HTML stand for?", "Hyper Transfer Markup Language", "Hyper Text Markup Language", "High Tech Modern Language", "Hyperlink and Text Markup Language", "Hyper Text Markup Language"));
                list.add(new QuizModel("What is the main function of RAM in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("What is the purpose of an operating system?", "Running computer games", "Managing hardware and software resources", "Creating documents", "Browsing the internet", "Managing hardware and software resources"));
                list.add(new QuizModel("Which of the following is a high-level programming language?", "Assembly language", "Machine language", "Python", "Binary code", "Python"));
                list.add(new QuizModel("What does URL stand for?", "Universal Resource Locator", "Uniform Resource Locator", "Unique Resource Locator", "Universal Reference Locator", "Uniform Resource Locator"));
                list.add(new QuizModel("Which company developed the C# programming language?", "Google", "Microsoft", "Apple", "Oracle", "Microsoft"));
                list.add(new QuizModel("What does GUI stand for in the context of computers?", "Graphical User Interface", "Graphical Unifying Interface", "General User Interface", "Graphics Utility Interface", "Graphical User Interface"));
                list.add(new QuizModel("What is the primary purpose of a firewall in computer security?", "Providing physical security for computers", "Protecting against viruses", "Filtering network traffic", "Blocking access to websites", "Filtering network traffic"));
                list.add(new QuizModel("What is the binary system?", "A numbering system based on the digits 0, 1, 2, and 3", "A numbering system based on the digits 0 and 1", "A numbering system based on the digits 0 to 9", "A numbering system based on the digits 0 to 15", "A numbering system based on the digits 0 and 1"));
                list.add(new QuizModel("Which of the following is an example of a web browser?", "Microsoft Word", "Google Chrome", "Adobe Photoshop", "Windows Media Player", "Google Chrome"));
                list.add(new QuizModel("What is the main function of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What is the purpose of a cache memory in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("Which programming language is often used for artificial intelligence and machine learning?", "JavaScript", "C++", "Python", "Ruby", "Python"));

                setup();
                break;


            case "Computer Test 2":
                list.add(new QuizModel("What does DNS stand for in the context of the internet?", "Dynamic Naming System", "Domain Name System", "Digital Network Server", "Data Naming Service", "Domain Name System"));
                list.add(new QuizModel("What is the main function of an email client program?", "Editing images", "Playing music", "Sending and receiving emails", "Creating spreadsheets", "Sending and receiving emails"));
                list.add(new QuizModel("Which of the following is not an example of an input device?", "Keyboard", "Monitor", "Mouse", "Scanner", "Monitor"));
                list.add(new QuizModel("What is the purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What does CPU stand for?", "Central Programming Unit", "Computer Personal Unit", "Central Processing Unit", "Central Process Unit", "Central Processing Unit"));
                list.add(new QuizModel("What is the primary function of an operating system?", "Running software applications", "Managing hardware and software resources", "Creating documents", "Playing multimedia files", "Managing hardware and software resources"));
                list.add(new QuizModel("Which of the following programming languages is often used for web development?", "Java", "Python", "C++", "JavaScript", "JavaScript"));
                list.add(new QuizModel("What does HTML stand for?", "Hyper Transfer Markup Language", "Hyper Text Markup Language", "High Tech Modern Language", "Hyperlink and Text Markup Language", "Hyper Text Markup Language"));
                list.add(new QuizModel("What is the purpose of RAM in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("What is the main function of a firewall in computer security?", "Providing physical security for computers", "Protecting against viruses", "Filtering network traffic", "Blocking access to websites", "Filtering network traffic"));
                list.add(new QuizModel("What is the binary system?", "A numbering system based on the digits 0, 1, 2, and 3", "A numbering system based on the digits 0 and 1", "A numbering system based on the digits 0 to 9", "A numbering system based on the digits 0 to 15", "A numbering system based on the digits 0 and 1"));
                list.add(new QuizModel("Which of the following is an example of a web browser?", "Microsoft Word", "Google Chrome", "Adobe Photoshop", "Windows Media Player", "Google Chrome"));
                list.add(new QuizModel("What is the primary purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What is the purpose of a cache memory in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("What does GUI stand for in the context of computers?", "Graphical User Interface", "Graphical Unifying Interface", "General User Interface", "Graphics Utility Interface", "Graphical User Interface"));

                setup();
                break;

            case "Computer Test 3":

                list.add(new QuizModel("Which programming language is often used for artificial intelligence and machine learning?", "JavaScript", "C++", "Python", "Ruby", "Python"));
                list.add(new QuizModel("What does DNS stand for in the context of the internet?", "Dynamic Naming System", "Domain Name System", "Digital Network Server", "Data Naming Service", "Domain Name System"));
                list.add(new QuizModel("What is the main function of an email client program?", "Editing images", "Playing music", "Sending and receiving emails", "Creating spreadsheets", "Sending and receiving emails"));
                list.add(new QuizModel("Which of the following is not an example of an input device?", "Keyboard", "Monitor", "Mouse", "Scanner", "Monitor"));
                list.add(new QuizModel("What is the purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What does CPU stand for?", "Central Programming Unit", "Computer Personal Unit", "Central Processing Unit", "Central Process Unit", "Central Processing Unit"));
                list.add(new QuizModel("What is the primary function of an operating system?", "Running software applications", "Managing hardware and software resources", "Creating documents", "Playing multimedia files", "Managing hardware and software resources"));
                list.add(new QuizModel("Which of the following programming languages is often used for web development?", "Java", "Python", "C++", "JavaScript", "JavaScript"));
                list.add(new QuizModel("What does HTML stand for?", "Hyper Transfer Markup Language", "Hyper Text Markup Language", "High Tech Modern Language", "Hyperlink and Text Markup Language", "Hyper Text Markup Language"));
                list.add(new QuizModel("What is the purpose of RAM in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("What is the main function of a firewall in computer security?", "Providing physical security for computers", "Protecting against viruses", "Filtering network traffic", "Blocking access to websites", "Filtering network traffic"));
                list.add(new QuizModel("What is the binary system?", "A numbering system based on the digits 0, 1, 2, and 3", "A numbering system based on the digits 0 and 1", "A numbering system based on the digits 0 to 9", "A numbering system based on the digits 0 to 15", "A numbering system based on the digits 0 and 1"));
                list.add(new QuizModel("Which of the following is an example of a web browser?", "Microsoft Word", "Google Chrome", "Adobe Photoshop", "Windows Media Player", "Google Chrome"));
                list.add(new QuizModel("What is the primary purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What does GUI stand for in the context of computers?", "Graphical User Interface", "Graphical Unifying Interface", "General User Interface", "Graphics Utility Interface", "Graphical User Interface"));

                setup();
                break;

            case "Computer Test 4":

                list.add(new QuizModel("What is the purpose of a cache memory in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("Which programming language is often used for artificial intelligence and machine learning?", "JavaScript", "C++", "Python", "Ruby", "Python"));
                list.add(new QuizModel("What does DNS stand for in the context of the internet?", "Dynamic Naming System", "Domain Name System", "Digital Network Server", "Data Naming Service", "Domain Name System"));
                list.add(new QuizModel("What is the main function of an email client program?", "Editing images", "Playing music", "Sending and receiving emails", "Creating spreadsheets", "Sending and receiving emails"));
                list.add(new QuizModel("Which of the following is not an example of an input device?", "Keyboard", "Monitor", "Mouse", "Scanner", "Monitor"));
                list.add(new QuizModel("What is the purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What does CPU stand for?", "Central Programming Unit", "Computer Personal Unit", "Central Processing Unit", "Central Process Unit", "Central Processing Unit"));
                list.add(new QuizModel("What is the primary function of an operating system?", "Running software applications", "Managing hardware and software resources", "Creating documents", "Playing multimedia files", "Managing hardware and software resources"));
                list.add(new QuizModel("Which of the following programming languages is often used for web development?", "Java", "Python", "C++", "JavaScript", "JavaScript"));
                list.add(new QuizModel("What does HTML stand for?", "Hyper Transfer Markup Language", "Hyper Text Markup Language", "High Tech Modern Language", "Hyperlink and Text Markup Language", "Hyper Text Markup Language"));
                list.add(new QuizModel("What is the purpose of RAM in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("What is the main function of a firewall in computer security?", "Providing physical security for computers", "Protecting against viruses", "Filtering network traffic", "Blocking access to websites", "Filtering network traffic"));
                list.add(new QuizModel("What is the binary system?", "A numbering system based on the digits 0, 1, 2, and 3", "A numbering system based on the digits 0 and 1", "A numbering system based on the digits 0 to 9", "A numbering system based on the digits 0 to 15", "A numbering system based on the digits 0 and 1"));
                list.add(new QuizModel("Which of the following is an example of a web browser?", "Microsoft Word", "Google Chrome", "Adobe Photoshop", "Windows Media Player", "Google Chrome"));
                list.add(new QuizModel("Which programming language is often used for building interactive and dynamic web pages?", "Python", "Java", "C++", "JavaScript", "JavaScript"));

                setup();
                break;

            case "Computer Test 5":
                list.add(new QuizModel("What is the primary purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What is the purpose of a cache memory in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("Which programming language is often used for artificial intelligence and machine learning?", "JavaScript", "C++", "Python", "Ruby", "Python"));
                list.add(new QuizModel("What does DNS stand for in the context of the internet?", "Dynamic Naming System", "Domain Name System", "Digital Network Server", "Data Naming Service", "Domain Name System"));
                list.add(new QuizModel("What is the main function of an email client program?", "Editing images", "Playing music", "Sending and receiving emails", "Creating spreadsheets", "Sending and receiving emails"));
                list.add(new QuizModel("Which of the following is not an example of an input device?", "Keyboard", "Monitor", "Mouse", "Scanner", "Monitor"));
                list.add(new QuizModel("What is the purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What does CPU stand for?", "Central Programming Unit", "Computer Personal Unit", "Central Processing Unit", "Central Process Unit", " Central Processing Unit"));
                list.add(new QuizModel("What is the primary function of an operating system?", "Running software applications", "Managing hardware and software resources", "Creating documents", "Playing multimedia files", "Managing hardware and software resources"));
                list.add(new QuizModel("Which of the following programming languages is often used for web development?", "Java", "Python", "C++", "JavaScript", "JavaScript"));
                list.add(new QuizModel("What does HTML stand for?", "Hyper Transfer Markup Language", "Hyper Text Markup Language", "High Tech Modern Language", "Hyperlink and Text Markup Language", "Hyper Text Markup Language"));
                list.add(new QuizModel("What is the purpose of RAM in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("What is the main function of a firewall in computer security?", "Providing physical security for computers", "Protecting against viruses", "Filtering network traffic", "Blocking access to websites", "Filtering network traffic"));
                list.add(new QuizModel("What is the binary system?", "A numbering system based on the digits 0, 1, 2, and 3", "A numbering system based on the digits 0 and 1", "A numbering system based on the digits 0 to 9", "A numbering system based on the digits 0 to 15", "A numbering system based on the digits 0 and 1"));
                list.add(new QuizModel("What does 'API' stand for in web services?", "Application Programming Interface", "Advanced Programming Interface", "Automated Programming Interface", "Application Program Interface", "Application Programming Interface"));

                setup();
                break;

            case "Computer Test 6":
                list.add(new QuizModel("Which of the following is an example of a web browser?", "Microsoft Word", "Google Chrome", "Adobe Photoshop", "Windows Media Player", "Google Chrome"));
                list.add(new QuizModel("What is the primary purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What is the purpose of a cache memory in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("Which programming language is often used for artificial intelligence and machine learning?", "JavaScript", "C++", "Python", "Ruby", "Python"));
                list.add(new QuizModel("What does DNS stand for in the context of the internet?", "Dynamic Naming System", "Domain Name System", "Digital Network Server", "Data Naming Service", "Domain Name System"));
                list.add(new QuizModel("What is the main function of an email client program?", "Editing images", "Playing music", "Sending and receiving emails", "Creating spreadsheets", "Sending and receiving emails"));
                list.add(new QuizModel("Which of the following is not an example of an input device?", "Keyboard", "Monitor", "Mouse", "Scanner", "Monitor"));
                list.add(new QuizModel("What is the purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What does CPU stand for?", "Central Programming Unit", "Computer Personal Unit", "Central Processing Unit", "Central Process Unit", "Central Processing Unit"));
                list.add(new QuizModel("What is the primary function of an operating system?", "Running software applications", "Managing hardware and software resources", "Creating documents", "Playing multimedia files", "Managing hardware and software resources"));
                list.add(new QuizModel("Which of the following programming languages is often used for web development?", "Java", "Python", "C++", "JavaScript", "JavaScript"));
                list.add(new QuizModel("What does HTML stand for?", "Hyper Transfer Markup Language", "Hyper Text Markup Language", "High Tech Modern Language", "Hyperlink and Text Markup Language", "Hyper Text Markup Language"));
                list.add(new QuizModel("What is the purpose of RAM in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("What is the main function of a firewall in computer security?", "Providing physical security for computers", "Protecting against viruses", "Filtering network traffic", "Blocking access to websites", "Filtering network traffic"));
                list.add(new QuizModel("What does 'PHP' stand for in web development?", "Hypertext Preprocessor", "Personal Home Page", "Programming Hyper Processor", "Public Hosted Platform", "Hypertext Preprocessor"));


                setup();
                break;

            case "Computer Test 7":
                list.add(new QuizModel("What is the binary system?", "A numbering system based on the digits 0, 1, 2, and 3", "A numbering system based on the digits 0 and 1", "A numbering system based on the digits 0 to 9", "A numbering system based on the digits 0 to 15", "A numbering system based on the digits 0 and 1"));
                list.add(new QuizModel("Which of the following is an example of a web browser?", "Microsoft Word", "Google Chrome", "Adobe Photoshop", "Windows Media Player", "Google Chrome"));
                list.add(new QuizModel("What is the primary purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What is the purpose of a cache memory in a computer?", "Long-term storage of data", "Temporary storage of data", "Running the operating system", "Displaying graphics", "Temporary storage of data"));
                list.add(new QuizModel("Which programming language is often used for artificial intelligence and machine learning?", "JavaScript", "C++", "Python", "Ruby", "Python"));
                list.add(new QuizModel("What does DNS stand for in the context of the internet?", "Dynamic Naming System", "Domain Name System", "Digital Network Server", "Data Naming Service", "Domain Name System"));
                list.add(new QuizModel("What is the main function of an email client program?", "Editing images", "Playing music", "Sending and receiving emails", "Creating spreadsheets", "Sending and receiving emails"));
                list.add(new QuizModel("Which of the following is not an example of an input device?", "Keyboard", "Monitor", "Mouse", "Scanner", "Monitor"));
                list.add(new QuizModel("What is the purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What does CPU stand for?", "Central Programming Unit", "Computer Personal Unit", "Central Processing Unit", "Central Process Unit", "Central Processing Unit"));
                list.add(new QuizModel("What is the primary function of an operating system?", "Running software applications", "Managing hardware and software resources", "Creating documents", "Playing multimedia files", "Managing hardware and software resources"));
                list.add(new QuizModel("Which of the following programming languages is often used for web development?", "Java", "Python", "C++", "JavaScript", "JavaScript"));
                list.add(new QuizModel("Which of the following is an example of a web browser?", "Microsoft Word", "Google Chrome", "Adobe Photoshop", "Windows Media Player", "Google Chrome"));
                list.add(new QuizModel("What is the primary purpose of a compiler in programming?", "Writing code", "Executing code", "Translating code to machine language", "Debugging code", "Translating code to machine language"));
                list.add(new QuizModel("What is the purpose of 'AJAX' in web development?", "Asynchronous data exchange with the server", "Executing server-side code", "Creating databases", "Styling web pages", "Asynchronous data exchange with the server"));

                setup();
                break;


                // Computer section end



            // History question started

            case "History Test 1":
                list.add(new QuizModel("Who was the first Emperor of the Maurya Dynasty in ancient India?", "Chandragupta Maurya", "Ashoka the Great", "Bindusara", "Samudragupta", "Chandragupta Maurya"));
                list.add(new QuizModel("What ancient civilization is known for building the Great Pyramids of Giza?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "China", "Egypt"));
                list.add(new QuizModel("Who was the first President of the United States of America?", "John Adams", "Thomas Jefferson", "George Washington", "Benjamin Franklin", "George Washington"));
                list.add(new QuizModel("Which famous explorer is credited with discovering the sea route to India in the 15th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Vasco da Gama"));
                list.add(new QuizModel("Who wrote the epic poem 'The Iliad' about the Trojan War?", "Homer", "Virgil", "Plato", "Aristotle", "Homer"));
                list.add(new QuizModel("Which ancient civilization is known for its invention of writing using cuneiform script?", "Egypt", "Indus Valley Civilization", "Sumer", "Mesoamerica", "Sumer"));
                list.add(new QuizModel("Who was the first Emperor of the Roman Empire?", "Julius Caesar", "Nero", "Augustus", "Constantine the Great", "Augustus"));
                list.add(new QuizModel("Which famous battle in 1066 marked the Norman conquest of England?", "Battle of Bannockburn", "Battle of Stamford Bridge", "Battle of Agincourt", "Battle of Hastings", "Battle of Hastings"));
                list.add(new QuizModel("Who was the founder of Buddhism?", "Siddhartha Gautama", "Confucius", "Laozi", "Ashoka", "Siddhartha Gautama"));
                list.add(new QuizModel("Which ancient civilization is known for the construction of the Great Wall?", "Egypt", "Greece", "China", "Rome", "China"));
                list.add(new QuizModel("Who was the leader of the Indian independence movement against British colonial rule?", "Jawaharlal Nehru", "Subhas Chandra Bose", "Mahatma Gandhi", "Sardar Patel", "Mahatma Gandhi"));
                list.add(new QuizModel("What ancient city is famous for the Hanging Gardens, one of the Seven Wonders of the Ancient World?", "Athens", "Babylon", "Rome", "Thebes", "Babylon"));
                list.add(new QuizModel("Who was the first woman to fly solo across the Atlantic Ocean?", "Amelia Earhart", "Bessie Coleman", "Harriet Quimby", "Jacqueline Cochran", "Amelia Earhart"));
                list.add(new QuizModel("Which famous document, signed in 1215, limited the power of the English monarchy?", "Declaration of Independence", "Magna Carta", "Bill of Rights", "Emancipation Proclamation", "Magna Carta"));
                list.add(new QuizModel("Who is known as the 'Father of the Indian Constitution'?", "B.R. Ambedkar", "Jawaharlal Nehru", "Mahatma Gandhi", "Sardar Patel", "B.R. Ambedkar"));

                setup();
                break;

            case "History Test 2":
                list.add(new QuizModel("Who was the first woman to be elected as the Prime Minister of India?", "Indira Gandhi", "Sarojini Naidu", "Kiran Bedi", "Pratibha Patil", "Indira Gandhi"));
                list.add(new QuizModel("Which famous Roman general and statesman led the conquest of Gaul and was later assassinated on the Ides of March?", "Julius Caesar", "Augustus", "Cicero", "Nero", "Julius Caesar"));
                list.add(new QuizModel("What was the name of the ship on which Charles Darwin sailed during his voyage of scientific discovery?", "HMS Endeavour", "HMS Beagle", "HMS Victory", "HMS Bounty", "HMS Beagle"));
                list.add(new QuizModel("Who was the founder of Sikhism, a religion that originated in the Indian subcontinent?", "Guru Nanak", "Guru Gobind Singh", "Guru Arjan", "Guru Tegh Bahadur", "Guru Nanak"));
                list.add(new QuizModel("Which famous battle in 480 BC saw the Greek city-states, led by Sparta, defeat the Persian Empire?", "Battle of Marathon", "Battle of Thermopylae", "Battle of Salamis", "Battle of Plataea", "Battle of Thermopylae"));
                list.add(new QuizModel("Who was the first woman to win a Nobel Prize and remains the only person to win Nobel Prizes in two different scientific fields?", "Marie Curie", "Rosalind Franklin", "Dorothy Crowfoot Hodgkin", "Barbara McClintock", "Marie Curie"));
                list.add(new QuizModel("Which civilization is known for the construction of the city of Machu Picchu in the Andes mountains?", "Maya civilization", "Inca Empire", "Aztec Empire", "Olmec civilization", "Inca Empire"));
                list.add(new QuizModel("Who was the first Emperor of China, known for unifying the country and building the Great Wall?", "Emperor Qin Shi Huang", "Emperor Han Wudi", "Emperor Tang Taizong", "Emperor Wu Zetian", "Emperor Qin Shi Huang"));
                list.add(new QuizModel("What was the name of the ship that carried the Pilgrims to North America in 1620?", "Mayflower", "Santa Maria", "Nina", "Victoria", "Mayflower"));
                list.add(new QuizModel("Who was the leader of the American Civil Rights Movement and is best known for his role in advancing civil rights through nonviolent civil disobedience?", "Malcolm X", "Nelson Mandela", "Martin Luther King Jr.", "Rosa Parks", "Martin Luther King Jr."));
                list.add(new QuizModel("Which famous treaty in 1783 officially ended the American Revolutionary War and recognized the United States as an independent nation?", "Treaty of Versailles", "Treaty of Tordesillas", "Treaty of Utrecht", "Treaty of Paris", "Treaty of Paris"));
                list.add(new QuizModel("Who was the first woman to fly solo nonstop across the Atlantic Ocean?", "Amelia Earhart", "Bessie Coleman", "Harriet Quimby", "Jacqueline Cochran", "Amelia Earhart"));
                list.add(new QuizModel("Which European explorer is credited with discovering the sea route to India in the late 15th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Vasco da Gama"));
                list.add(new QuizModel("What was the name of the famous ship that sank in 1912 on its maiden voyage and became the subject of numerous books and films?", "Lusitania", "Titanic", "Queen Mary", "Britannic", "Titanic"));
                list.add(new QuizModel("Which ancient civilization is known for the creation of the Rosetta Stone, which helped decipher hieroglyphs?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "China", "Egypt"));

                setup();
                break;

            case "History Test 3":
                list.add(new QuizModel("Who was the leader of the Bolshevik Party and the first leader of the Soviet Union?", "Joseph Stalin", "Leon Trotsky", "Vladimir Lenin", "Nikita Khrushchev", "Vladimir Lenin"));
                list.add(new QuizModel("Which ancient civilization is known for its advanced system of hieroglyphic writing?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "China", "Egypt"));
                list.add(new QuizModel("Who was the first President of South Africa after the end of apartheid?", "Nelson Mandela", "F.W. de Klerk", "Desmond Tutu", "Thabo Mbeki", "Nelson Mandela"));
                list.add(new QuizModel("What ancient city is famous for the Colosseum, an ancient amphitheater that hosted gladiatorial contests?", "Athens", "Babylon", "Rome", "Thebes", "Rome"));
                list.add(new QuizModel("Who was the first woman to be elected as the Chancellor of Germany and is one of the world's most powerful women?", "Margaret Thatcher", "Angela Merkel", "Theresa May", "Jacinda Ardern", "Angela Merkel"));
                list.add(new QuizModel("Which European country is known for its historical figure Joan of Arc, who played a significant role in the Hundred Years' War?", "France", "England", "Spain", "Italy", "France"));
                list.add(new QuizModel("Who is known as the 'Father of Modern Physics' and formulated the theory of relativity?", "Isaac Newton", "Niels Bohr", "Werner Heisenberg", "Albert Einstein", "Albert Einstein"));
                list.add(new QuizModel("Which ancient civilization is known for its construction of the Parthenon in Athens?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "Greece", "Greece"));
                list.add(new QuizModel("Who was the first woman to win a Nobel Prize and the only person to win Nobel Prizes in two different scientific fields?", "Marie Curie", "Rosalind Franklin", "Dorothy Crowfoot Hodgkin", "Barbara McClintock", "Marie Curie"));
                list.add(new QuizModel("What is the name of the ancient code of laws, often considered one of the earliest examples of written law, created by the Babylonian king Hammurabi?", "Code of Justinian", "Code of Napoleon", "Code of Hammurabi", "Code of Solomon", "Code of Hammurabi"));
                list.add(new QuizModel("Who was the founder of the Mongol Empire, which became the largest contiguous empire in history?", "Kublai Khan", "Genghis Khan", "Attila the Hun", "Tamerlane", "Genghis Khan"));
                list.add(new QuizModel("Which famous explorer is known for circumnavigating the globe in the 16th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Ferdinand Magellan"));
                list.add(new QuizModel("What is the name of the historic document signed by King John of England in 1215, which established the principle that the king is subject to the law?", "Magna Carta", "Bill of Rights", "Emancipation Proclamation", "Declaration of Independence", "Magna Carta"));
                list.add(new QuizModel("Who was the first President of the United States and a key figure in the American Revolutionary War?", "John Adams", "Thomas Jefferson", "George Washington", "Benjamin Franklin", "George Washington"));
                list.add(new QuizModel("Which ancient civilization is known for its extensive system of canals and the Hanging Gardens of Babylon?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "Greece", "Mesopotamia"));


                setup();
                break;

            case "History Test 4":
                list.add(new QuizModel("Who was the leader of the Indian independence movement and known as the 'Father of the Nation' in India?", "Jawaharlal Nehru", "Subhas Chandra Bose", "Mahatma Gandhi", "Sardar Patel", "Mahatma Gandhi"));
                list.add(new QuizModel("What ancient city is famous for the Temple of Artemis, one of the Seven Wonders of the Ancient World?", "Athens", "Babylon", "Rome", "Ephesus", "Ephesus"));
                list.add(new QuizModel("Who was the Russian mystic and advisor to the Romanov family, known for her influence on the Russian monarchy?", "Catherine the Great", "Rasputin", "Ivan the Terrible", "Peter the Great", "Rasputin"));
                list.add(new QuizModel("Which famous explorer is known for his travels along the Silk Road and his detailed accounts of Asian civilizations in the 13th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Marco Polo"));
                list.add(new QuizModel("What was the name of the ship that carried the Pilgrims to North America in 1620?", "Mayflower", "Santa Maria", "Nina", "Victoria", "Mayflower"));
                list.add(new QuizModel("Who was the leader of the American Civil Rights Movement and delivered the famous 'I Have a Dream' speech?", "Malcolm X", "Nelson Mandela", "Martin Luther King Jr.", "Rosa Parks", "Martin Luther King Jr."));
                list.add(new QuizModel("Which famous treaty in 1783 officially ended the American Revolutionary War and recognized the United States as an independent nation?", "Treaty of Versailles", "Treaty of Tordesillas", "Treaty of Utrecht", "Treaty of Paris", "Treaty of Paris"));
                list.add(new QuizModel("Who was the first woman to fly solo nonstop across the Atlantic Ocean?", "Amelia Earhart", "Bessie Coleman", "Harriet Quimby", "Jacqueline Cochran", "Amelia Earhart"));
                list.add(new QuizModel("Which European explorer is credited with discovering the sea route to India in the late 15th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Vasco da Gama"));
                list.add(new QuizModel("What was the name of the famous ship that sank in 1912 on its maiden voyage and became the subject of numerous books and films?", "Lusitania", "Titanic", "Queen Mary", "Britannic", "Titanic"));
                list.add(new QuizModel("Who was the leader of the Bolshevik Party and the first leader of the Soviet Union?", "Joseph Stalin", "Leon Trotsky", "Vladimir Lenin", "Nikita Khrushchev", "Vladimir Lenin"));
                list.add(new QuizModel("Which ancient civilization is known for its advanced system of hieroglyphic writing?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "China", "Egypt"));
                list.add(new QuizModel("Who was the first President of South Africa after the end of apartheid?", "Nelson Mandela", "F.W. de Klerk", "Desmond Tutu", "Thabo Mbeki", "Nelson Mandela"));
                list.add(new QuizModel("What ancient city is famous for the Colosseum, an ancient amphitheater that hosted gladiatorial contests?", "Athens", "Babylon", "Rome", "Thebes", "Rome"));
                list.add(new QuizModel("Who was the first woman to be elected as the Chancellor of Germany and is one of the world's most powerful women?", "Margaret Thatcher", "Angela Merkel", "Theresa May", "Jacinda Ardern", "Angela Merkel"));


                setup();
                break;

            case "History Test 5":
                list.add(new QuizModel("Which European country is known for its historical figure Joan of Arc, who played a significant role in the Hundred Years' War?", "France", "England", "Spain", "Italy", "France"));
                list.add(new QuizModel("Who is known as the 'Father of Modern Physics' and formulated the theory of relativity?", "Isaac Newton", "Niels Bohr", "Werner Heisenberg", "Albert Einstein", "Albert Einstein"));
                list.add(new QuizModel("Which ancient civilization is known for its construction of the Parthenon in Athens?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "Greece", "Greece"));
                list.add(new QuizModel("Who was the first woman to win a Nobel Prize and the only person to win Nobel Prizes in two different scientific fields?", "Marie Curie", "Rosalind Franklin", "Dorothy Crowfoot Hodgkin", "Barbara McClintock", "Marie Curie"));
                list.add(new QuizModel("What is the name of the ancient code of laws, often considered one of the earliest examples of written law, created by the Babylonian king Hammurabi?", "Code of Justinian", "Code of Napoleon", "Code of Hammurabi", "Code of Solomon", "Code of Hammurabi"));
                list.add(new QuizModel("Who was the founder of the Mongol Empire, which became the largest contiguous empire in history?", "Kublai Khan", "Genghis Khan", "Attila the Hun", "Tamerlane", "Genghis Khan"));
                list.add(new QuizModel("Which famous explorer is known for circumnavigating the globe in the 16th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Ferdinand Magellan"));
                list.add(new QuizModel("What is the name of the historic document signed by King John of England in 1215, which established the principle that the king is subject to the law?", "Magna Carta", "Bill of Rights", "Emancipation Proclamation", "Declaration of Independence", "Magna Carta"));
                list.add(new QuizModel("Who was the first President of the United States and a key figure in the American Revolutionary War?", "John Adams", "Thomas Jefferson", "George Washington", "Benjamin Franklin", "George Washington"));
                list.add(new QuizModel("Which ancient civilization is known for its extensive system of canals and the Hanging Gardens of Babylon?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "Greece", "Mesopotamia"));
                list.add(new QuizModel("Who was the leader of the Indian independence movement and known as the 'Father of the Nation' in India?", "Jawaharlal Nehru", "Subhas Chandra Bose", "Mahatma Gandhi", "Sardar Patel", "Mahatma Gandhi"));
                list.add(new QuizModel("What ancient city is famous for the Temple of Artemis, one of the Seven Wonders of the Ancient World?", "Athens", "Babylon", "Rome", "Ephesus", "Ephesus"));
                list.add(new QuizModel("Who was the Russian mystic and advisor to the Romanov family, known for her influence on the Russian monarchy?", "Catherine the Great", "Rasputin", "Ivan the Terrible", "Peter the Great", "Rasputin"));
                list.add(new QuizModel("Which famous explorer is known for his travels along the Silk Road and his detailed accounts of Asian civilizations in the 13th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Marco Polo"));
                list.add(new QuizModel("What was the name of the ship that carried the Pilgrims to North America in 1620?", "Mayflower", "Santa Maria", "Nina", "Victoria", "Mayflower"));
                setup();
                break;

            case "History Test 6":
                list.add(new QuizModel("Who was the leader of the American Civil Rights Movement and delivered the famous 'I Have a Dream' speech?", "Malcolm X", "Nelson Mandela", "Martin Luther King Jr.", "Rosa Parks", "Martin Luther King Jr."));
                list.add(new QuizModel("Which famous treaty in 1783 officially ended the American Revolutionary War and recognized the United States as an independent nation?", "Treaty of Versailles", "Treaty of Tordesillas", "Treaty of Utrecht", "Treaty of Paris", "Treaty of Paris"));
                list.add(new QuizModel("Who was the first woman to fly solo nonstop across the Atlantic Ocean?", "Amelia Earhart", "Bessie Coleman", "Harriet Quimby", "Jacqueline Cochran", "Amelia Earhart"));
                list.add(new QuizModel("Which European explorer is credited with discovering the sea route to India in the late 15th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Vasco da Gama"));
                list.add(new QuizModel("What was the name of the famous ship that sank in 1912 on its maiden voyage and became the subject of numerous books and films?", "Lusitania", "Titanic", "Queen Mary", "Britannic", "Titanic"));
                list.add(new QuizModel("Who was the leader of the Bolshevik Party and the first leader of the Soviet Union?", "Joseph Stalin", "Leon Trotsky", "Vladimir Lenin", "Nikita Khrushchev", "Vladimir Lenin"));
                list.add(new QuizModel("Which ancient civilization is known for its advanced system of hieroglyphic writing?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "China", "Egypt"));
                list.add(new QuizModel("Who was the first President of South Africa after the end of apartheid?", "Nelson Mandela", "F.W. de Klerk", "Desmond Tutu", "Thabo Mbeki", "Nelson Mandela"));
                list.add(new QuizModel("What ancient city is famous for the Colosseum, an ancient amphitheater that hosted gladiatorial contests?", "Athens", "Babylon", "Rome", "Thebes", "Rome"));
                list.add(new QuizModel("Who was the first woman to be elected as the Chancellor of Germany and is one of the world's most powerful women?", "Margaret Thatcher", "Angela Merkel", "Theresa May", "Jacinda Ardern", "Angela Merkel"));
                list.add(new QuizModel("Which European country is known for its historical figure Joan of Arc, who played a significant role in the Hundred Years' War?", "France", "England", "Spain", "Italy", "France"));
                list.add(new QuizModel("Who is known as the 'Father of Modern Physics' and formulated the theory of relativity?", "Isaac Newton", "Niels Bohr", "Werner Heisenberg", "Albert Einstein", "Albert Einstein"));
                list.add(new QuizModel("Which ancient civilization is known for its construction of the Parthenon in Athens?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "Greece", "Greece"));
                list.add(new QuizModel("Who was the first woman to win a Nobel Prize and the only person to win Nobel Prizes in two different scientific fields?", "Marie Curie", "Rosalind Franklin", "Dorothy Crowfoot Hodgkin", "Barbara McClintock", "Marie Curie"));
                list.add(new QuizModel("Who is known as the 'Father of Modern Physics' and formulated the theory of relativity?", "Isaac Newton", "Niels Bohr", "Werner Heisenberg", "Albert Einstein", "Albert Einstein"));

                setup();
                break;

            case "History Test 7":
                list.add(new QuizModel("What is the name of the ancient code of laws, often considered one of the earliest examples of written law, created by the Babylonian king Hammurabi?", "Code of Justinian", "Code of Napoleon", "Code of Hammurabi", "Code of Solomon", "Code of Hammurabi"));
                list.add(new QuizModel("Who was the founder of the Mongol Empire, which became the largest contiguous empire in history?", "Kublai Khan", "Genghis Khan", "Attila the Hun", "Tamerlane", "Genghis Khan"));
                list.add(new QuizModel("Which famous explorer is known for circumnavigating the globe in the 16th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Ferdinand Magellan"));
                list.add(new QuizModel("What is the name of the historic document signed by King John of England in 1215, which established the principle that the king is subject to the law?", "Magna Carta", "Bill of Rights", "Emancipation Proclamation", "Declaration of Independence", "Magna Carta"));
                list.add(new QuizModel("Who was the first President of the United States and a key figure in the American Revolutionary War?", "John Adams", "Thomas Jefferson", "George Washington", "Benjamin Franklin", "George Washington"));
                list.add(new QuizModel("Which ancient civilization is known for its extensive system of canals and the Hanging Gardens of Babylon?", "Mesopotamia", "Indus Valley Civilization", "Egypt", "Greece", "Mesopotamia"));
                list.add(new QuizModel("Who was the leader of the Indian independence movement and known as the 'Father of the Nation' in India?", "Jawaharlal Nehru", "Subhas Chandra Bose", "Mahatma Gandhi", "Sardar Patel", "Mahatma Gandhi"));
                list.add(new QuizModel("What ancient city is famous for the Temple of Artemis, one of the Seven Wonders of the Ancient World?", "Athens", "Babylon", "Rome", "Ephesus", "Ephesus"));
                list.add(new QuizModel("Who was the Russian mystic and advisor to the Romanov family, known for her influence on the Russian monarchy?", "Catherine the Great", "Rasputin", "Ivan the Terrible", "Peter the Great", "Rasputin"));
                list.add(new QuizModel("Which famous explorer is known for his travels along the Silk Road and his detailed accounts of Asian civilizations in the 13th century?", "Christopher Columbus", "Ferdinand Magellan", "Vasco da Gama", "Marco Polo", "Marco Polo"));
                list.add(new QuizModel("What was the name of the ship that carried the Pilgrims to North America in 1620?", "Mayflower", "Santa Maria", "Nina", "Victoria", "Mayflower"));
                list.add(new QuizModel("Who was the leader of the American Civil Rights Movement and delivered the famous 'I Have a Dream' speech?", "Malcolm X", "Nelson Mandela", "Martin Luther King Jr.", "Rosa Parks", "Martin Luther King Jr."));
                list.add(new QuizModel("Which famous treaty in 1783 officially ended the American Revolutionary War and recognized the United States as an independent nation?", "Treaty of Versailles", "Treaty of Tordesillas", "Treaty of Utrecht", "Treaty of Paris", "Treaty of Paris"));
                list.add(new QuizModel("Who was the first woman to fly solo nonstop across the Atlantic Ocean?", "Amelia Earhart", "Bessie Coleman", "Harriet Quimby", "Jacqueline Cochran", "Amelia Earhart"));
                list.add(new QuizModel("What ancient city is famous for the Colosseum, an ancient amphitheater that hosted gladiatorial contests?", "Athens", "Babylon", "Rome", "Thebes", "Rome"));
                setup();
                break;

                // Biology start

            case "Biology Test 1":

                list.add(new QuizModel("What is the basic unit of life?", "Cell", "Molecule", "Organ", "Tissue", "Cell"));
                list.add(new QuizModel("Which gas do plants absorb from the atmosphere during photosynthesis?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Carbon dioxide"));
                list.add(new QuizModel("What is the powerhouse of the cell?", "Mitochondria", "Nucleus", "Endoplasmic reticulum", "Golgi apparatus", "Mitochondria"));
                list.add(new QuizModel("What is the process by which plants make their own food?", "Respiration", "Photosynthesis", "Digestion", "Fermentation", "Photosynthesis"));
                list.add(new QuizModel("Which gas is responsible for the greenhouse effect?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the largest organ in the human body?", "Heart", "Liver", "Brain", "Skin", "Skin"));
                list.add(new QuizModel("What is the function of red blood cells?", "Transport oxygen", "Digest food", "Produce antibodies", "Produce insulin", "Transport oxygen"));
                list.add(new QuizModel("Which part of the plant conducts photosynthesis?", "Roots", "Leaves", "Stem", "Flower", "Leaves"));
                list.add(new QuizModel("What is the chemical symbol for water?", "H2O2", "CO2", "H2O", "O2", "H2O"));
                list.add(new QuizModel("Which gas do humans exhale when they breathe out?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the process by which plants lose water vapor through small openings in their leaves?", "Transpiration", "Respiration", "Photosynthesis", "Diffusion", "Transpiration"));
                list.add(new QuizModel("What is the study of heredity and the variation of inherited characteristics?", "Ecology", "Genetics", "Botany", "Zoology", "Genetics"));
                list.add(new QuizModel("Which gas is essential for respiration?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Oxygen"));
                list.add(new QuizModel("What is the outermost layer of the skin called?", "Epidermis", "Dermis", "Hypodermis", "Stratum corneum", "Epidermis"));
                list.add(new QuizModel("What is the powerhouse of the cell responsible for generating energy?", "Mitochondria", "Nucleus", "Endoplasmic reticulum", "Golgi apparatus", "Mitochondria"));

                setup();
                break;

            case "Biology Test 2":

                list.add(new QuizModel("Which gas is produced during the process of fermentation?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the scientific name for the human brain?", "Cerebellum", "Neocortex", "Cerebrum", "Medulla oblongata", "Cerebrum"));
                list.add(new QuizModel("Which part of the eye is responsible for controlling the amount of light entering the eye?", "Cornea", "Iris", "Retina", "Lens", "Iris"));
                list.add(new QuizModel("What is the pigment responsible for the color of human skin, hair, and eyes?", "Melanin", "Hemoglobin", "Chlorophyll", "Keratin", "Melanin"));
                list.add(new QuizModel("Which gas is a major component of the Earth's atmosphere?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Nitrogen"));
                list.add(new QuizModel("What is the smallest unit of matter that retains the properties of an element?", "Cell", "Molecule", "Atom", "Proton", "Atom"));
                list.add(new QuizModel("Which blood type is considered the universal donor?", "A", "B", "AB", "O", "O"));
                list.add(new QuizModel("What is the process by which plants bend towards a light source?", "Phototropism", "Geotropism", "Hydrotropism", "Thigmotropism", "Phototropism"));
                list.add(new QuizModel("What is the chemical formula for glucose?", "C6H12O6", "H2O", "CO2", "NaCl", "C6H12O6"));
                list.add(new QuizModel("Which gas is responsible for the formation of acid rain?", "Oxygen", "Carbon dioxide", "Sulfur dioxide", "Methane", "Sulfur dioxide"));
                list.add(new QuizModel("Which part of the human digestive system is responsible for absorbing water and minerals from undigested food?", "Stomach", "Small intestine", "Large intestine", "Esophagus", "Large intestine"));
                list.add(new QuizModel("What is the process by which plants take in water from the soil?", "Phototropism", "Geotropism", "Hydrotropism", "Thigmotropism", "Hydrotropism"));
                list.add(new QuizModel("Which gas is produced by plants during photosynthesis?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Oxygen"));
                list.add(new QuizModel("What is the study of the interactions between organisms and their environment called?", "Genetics", "Botany", "Zoology", "Ecology", "Ecology"));
                list.add(new QuizModel("Which gas is used by plants during photosynthesis to produce glucose?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Carbon dioxide"));

                setup();
                break;

            case "Biology Test 3":

                list.add(new QuizModel("What is the largest organ in the human body?", "Heart", "Liver", "Brain", "Skin", "Skin"));
                list.add(new QuizModel("What is the function of red blood cells?", "Transport oxygen", "Digest food", "Produce antibodies", "Produce insulin", "Transport oxygen"));
                list.add(new QuizModel("Which part of the plant conducts photosynthesis?", "Roots", "Leaves", "Stem", "Flower", "Leaves"));
                list.add(new QuizModel("What is the chemical process by which food is broken down in cells to release energy?", "Photosynthesis", "Digestion", "Respiration", "Fermentation", "Respiration"));
                list.add(new QuizModel("Which organelle is responsible for protein synthesis in the cell?", "Nucleus", "Mitochondria", "Ribosome", "Endoplasmic reticulum", "Ribosome"));
                list.add(new QuizModel("What is the main function of the circulatory system?", "Digestion", "Respiration", "Transportation", "Reproduction", "Transportation"));
                list.add(new QuizModel("Which gas is released by plants during transpiration?", "Oxygen", "Carbon dioxide", "Nitrogen", "Water vapor", "Water vapor"));
                list.add(new QuizModel("What is the process by which organisms convert food into energy and carbon dioxide?", "Photosynthesis", "Digestion", "Respiration", "Fermentation", "Respiration"));
                list.add(new QuizModel("What is the name of the sac-like structure that stores bile produced by the liver?", "Gallbladder", "Stomach", "Pancreas", "Small intestine", "Gallbladder"));
                list.add(new QuizModel("Which part of the human eye contains photoreceptor cells responsible for vision?", "Cornea", "Iris", "Retina", "Lens", "Retina"));
                list.add(new QuizModel("What is the process by which green plants convert light energy into chemical energy in the form of glucose?", "Photosynthesis", "Respiration", "Digestion", "Fermentation", "Photosynthesis"));
                list.add(new QuizModel("Which gas is produced by the combustion of fossil fuels and contributes to air pollution?", "Oxygen", "Carbon dioxide", "Methane", "Sulfur dioxide", "Sulfur dioxide"));
                list.add(new QuizModel("What is the name of the pigment that allows plants to capture sunlight for photosynthesis?", "Chlorophyll", "Melanin", "Hemoglobin", "Keratin", "Chlorophyll"));
                list.add(new QuizModel("Which blood component is responsible for carrying oxygen throughout the body?", "Plasma", "White blood cells", "Platelets", "Red blood cells", "Red blood cells"));
                list.add(new QuizModel("What is the largest mammalian organ that detoxifies harmful substances and stores glycogen?", "Heart", "Liver", "Brain", "Skin", "Liver"));

                setup();
                break;

            case "Biology Test 4":

                list.add(new QuizModel("What is the chemical symbol for water?", "H2O2", "CO2", "H2O", "O2", "H2O"));
                list.add(new QuizModel("Which gas do humans exhale when they breathe out?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the process by which plants lose water vapor through small openings in their leaves?", "Transpiration", "Respiration", "Photosynthesis", "Diffusion", "Transpiration"));
                list.add(new QuizModel("What is the study of heredity and the variation of inherited characteristics?", "Ecology", "Genetics", "Botany", "Zoology", "Genetics"));
                list.add(new QuizModel("Which gas is essential for respiration?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Oxygen"));
                list.add(new QuizModel("What is the outermost layer of the skin called?", "Epidermis", "Dermis", "Hypodermis", "Stratum corneum", "Epidermis"));
                list.add(new QuizModel("What is the powerhouse of the cell responsible for generating energy?", "Mitochondria", "Nucleus", "Endoplasmic reticulum", "Golgi apparatus", "Mitochondria"));
                list.add(new QuizModel("What is the chemical process by which food is broken down in cells to release energy?", "Photosynthesis", "Digestion", "Respiration", "Fermentation", "Respiration"));
                list.add(new QuizModel("Which organelle is responsible for protein synthesis in the cell?", "Nucleus", "Mitochondria", "Ribosome", "Endoplasmic reticulum", "Ribosome"));
                list.add(new QuizModel("What is the main function of the circulatory system?", "Digestion", "Respiration", "Transportation", "Reproduction", "Transportation"));
                list.add(new QuizModel("Which gas is produced during the process of fermentation?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the scientific name for the human brain?", "Cerebellum", "Neocortex", "Cerebrum", "Medulla oblongata", "Cerebrum"));
                list.add(new QuizModel("Which part of the eye is responsible for controlling the amount of light entering the eye?", "Cornea", "Iris", "Retina", "Lens", "Iris"));
                list.add(new QuizModel("What is the pigment responsible for the color of human skin, hair, and eyes?", "Melanin", "Hemoglobin", "Chlorophyll", "Keratin", "Melanin"));
                list.add(new QuizModel("Which gas is a major component of the Earth's atmosphere?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Nitrogen"));

                setup();
                break;

            case "Biology Test 5":
                list.add(new QuizModel("What is the smallest unit of matter that retains the properties of an element?", "Cell", "Molecule", "Atom", "Proton", "Atom"));
                list.add(new QuizModel("Which blood type is considered the universal donor?", "A", "B", "AB", "O", "O"));
                list.add(new QuizModel("What is the process by which plants bend towards a light source?", "Phototropism", "Geotropism", "Hydrotropism", "Thigmotropism", "Phototropism"));
                list.add(new QuizModel("What is the chemical formula for glucose?", "C6H12O6", "H2O", "CO2", "NaCl", "C6H12O6"));
                list.add(new QuizModel("Which gas is responsible for the formation of acid rain?", "Oxygen", "Carbon dioxide", "Sulfur dioxide", "Methane", "Sulfur dioxide"));
                list.add(new QuizModel("Which part of the human digestive system is responsible for absorbing water and minerals from undigested food?", "Stomach", "Small intestine", "Large intestine", "Esophagus", "Large intestine"));
                list.add(new QuizModel("What is the process by which plants take in water from the soil?", "Phototropism", "Geotropism", "Hydrotropism", "Thigmotropism", "Hydrotropism"));
                list.add(new QuizModel("Which gas is produced by plants during photosynthesis?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Oxygen"));
                list.add(new QuizModel("What is the study of the interactions between organisms and their environment called?", "Genetics", "Botany", "Zoology", "Ecology", "Ecology"));
                list.add(new QuizModel("Which gas is used by plants during photosynthesis to produce glucose?", "Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen", "Carbon dioxide"));
                list.add(new QuizModel("What is the process by which plants respond to touch or contact with solid objects?", "Phototropism", "Geotropism", "Hydrotropism", "Thigmotropism", "Thigmotropism"));
                list.add(new QuizModel("Which gas is produced in the human digestive system by the fermentation of undigested food?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the name of the process by which plants grow toward a light source?", "Phototropism", "Geotropism", "Hydrotropism", "Thigmotropism", "Phototropism"));
                list.add(new QuizModel("Which gas is released by certain types of bacteria during the process of nitrogen fixation?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Nitrogen"));
                list.add(new QuizModel("What is the name of the pigment responsible for the red color of blood when it binds with oxygen?", "Insulin", "Hemoglobin", "Glucagon", "Thyroxine", "Hemoglobin"));


                setup();
                break;

            case "Biology Test 6":

                list.add(new QuizModel("Which type of tissue connects bones to other bones in the human body?", "Muscle tissue", "Epithelial tissue", "Connective tissue", "Nervous tissue", "Connective tissue"));
                list.add(new QuizModel("What is the name of the process by which water molecules move from an area of high concentration to low concentration through a semipermeable membrane?", "Osmosis", "Diffusion", "Active transport", "Endocytosis", "Osmosis"));
                list.add(new QuizModel("Which gas is responsible for the acidic pH of the stomach?", "Oxygen", "Carbon dioxide", "Hydrochloric acid", "Sulfur dioxide", "Hydrochloric acid"));
                list.add(new QuizModel("What is the process by which animals release stored energy from food molecules in the absence of oxygen?", "Photosynthesis", "Digestion", "Respiration", "Fermentation", "Fermentation"));
                list.add(new QuizModel("Which part of the human brain is responsible for regulating basic functions such as breathing and heartbeat?", "Cerebellum", "Neocortex", "Cerebrum", "Medulla oblongata", "Medulla oblongata"));
                list.add(new QuizModel("What is the name of the tiny hair-like structures on the surface of some cells that are involved in movement?", "Cilia", "Flagella", "Microvilli", "Villi", "Cilia"));
                list.add(new QuizModel("Which gas is released by plants as a waste product of photosynthesis?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Oxygen"));
                list.add(new QuizModel("What is the process by which water is absorbed by plant roots from the soil?", "Phototropism", "Geotropism", "Hydrotropism", "Thigmotropism", "Hydrotropism"));
                list.add(new QuizModel("Which gas is essential for the process of respiration in animals?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Oxygen"));
                list.add(new QuizModel("What is the primary function of the respiratory system in humans?", "Transportation of nutrients", "Excretion of waste products", "Exchange of gases", "Digestion of food", "Exchange of gases"));
                list.add(new QuizModel("Which gas is responsible for the distinctive smell of rotten eggs?", "Oxygen", "Carbon dioxide", "Hydrogen sulfide", "Methane", "Hydrogen sulfide"));
                list.add(new QuizModel("What is the name of the fluid that surrounds and protects the brain and spinal cord?", "Blood", "Cerebrospinal fluid", "Synovial fluid", "Lymph", "Cerebrospinal fluid"));
                list.add(new QuizModel("Which part of the human digestive system is responsible for the absorption of nutrients into the bloodstream?", "Stomach", "Small intestine", "Large intestine", "Esophagus", "Small intestine"));
                list.add(new QuizModel("What is the process by which plants bend in response to gravity?", "Phototropism", "Geotropism", "Hydrotropism", "Thigmotropism", "Geotropism"));
                list.add(new QuizModel("Which gas is essential for the combustion of fuels?", "Oxygen", "Carbon dioxide", "Methane", "Sulfur dioxide", "Oxygen"));

                setup();
                break;

            case "Biology Test 7":

                list.add(new QuizModel("Which part of the human brain is responsible for coordinating movement and balance?", "Cerebellum", "Neocortex", "Cerebrum", "Medulla oblongata", "Cerebellum"));
                list.add(new QuizModel("What is the name of the fluid-filled sac in which a developing fetus is enclosed?", "Umbilical cord", "Amniotic sac", "Placenta", "Fertilization tube", "Amniotic sac"));
                list.add(new QuizModel("Which gas do animals inhale during respiration and exhale as a waste product?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the process by which animals obtain oxygen from the environment and release carbon dioxide?", "Photosynthesis", "Digestion", "Respiration", "Fermentation", "Respiration"));
                list.add(new QuizModel("Which gas is produced by the breakdown of organic matter in landfills and contributes to greenhouse gas emissions?", "Oxygen", "Carbon dioxide", "Methane", "Sulfur dioxide", "Methane"));
                list.add(new QuizModel("What is the name of the process by which a caterpillar transforms into a butterfly?", "Metamorphosis", "Photosynthesis", "Respiration", "Fermentation", "Metamorphosis"));
                list.add(new QuizModel("Which part of the human digestive system is responsible for breaking down food into smaller molecules through the action of enzymes?", "Stomach", "Small intestine", "Large intestine", "Esophagus", "Stomach"));
                list.add(new QuizModel("What is the name of the process by which organisms produce offspring similar to themselves?", "Respiration", "Photosynthesis", "Reproduction", "Digestion", "Reproduction"));
                list.add(new QuizModel("Which gas is released by volcanoes and geothermal sources?", "Oxygen", "Carbon dioxide", "Methane", "Sulfur dioxide", "Sulfur dioxide"));
                list.add(new QuizModel("What is the name of the protein responsible for carrying oxygen in red blood cells?", "Insulin", "Hemoglobin", "Glucagon", "Thyroxine", "Hemoglobin"));
                list.add(new QuizModel("What is the main function of the excretory system in humans?", "Transportation of nutrients", "Protection against diseases", "Removal of waste products", "Digestion of food", "Removal of waste products"));
                list.add(new QuizModel("Which gas is produced by bacteria in the intestines during digestion?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the process by which organisms release energy from glucose without using oxygen?", "Photosynthesis", "Digestion", "Respiration", "Fermentation", "Fermentation"));
                list.add(new QuizModel("What is the name of the pigment that gives plants their green color and is involved in photosynthesis?", "Chlorophyll", "Melanin", "Hemoglobin", "Keratin", "Chlorophyll"));
                list.add(new QuizModel("Which gas is released by volcanoes and contributes to air pollution?", "Oxygen", "Carbon dioxide", "Methane", "Sulfur dioxide", "Sulfur dioxide"));
                setup();
                break;

                // Biology ended



            // Chemistry start

            case "Chemistry Test 1":
                list.add(new QuizModel("What is the chemical symbol for gold?", "Au", "Ag", "Ge", "Go", "Au"));
                list.add(new QuizModel("Which gas is most abundant in Earth's atmosphere?", "Oxygen", "Nitrogen", "Carbon dioxide", "Hydrogen", "Nitrogen"));
                list.add(new QuizModel("What is the chemical formula for water?", "CO2", "H2O", "O3", "N2", "H2O"));
                list.add(new QuizModel("Which element is essential for all known forms of life on Earth?", "Carbon", "Helium", "Chlorine", "Sodium", "Carbon"));
                list.add(new QuizModel("What is the chemical symbol for silver?", "Si", "Ag", "Sv", "Sr", "Ag"));
                list.add(new QuizModel("Which gas is commonly known as laughing gas?", "Methane", "Carbon monoxide", "Nitrous oxide", "Ammonia", "Nitrous oxide"));
                list.add(new QuizModel("Which of the following is a noble gas?", "Neon", "Hydrogen", "Oxygen", "Sulfur", "Neon"));
                list.add(new QuizModel("What is the chemical formula for methane?", "CH4", "CO2", "H2O", "NH3", "CH4"));
                list.add(new QuizModel("Which element is found in the highest abundance in the Earth's crust?", "Aluminum", "Silicon", "Iron", "Calcium", "Silicon"));
                list.add(new QuizModel("What is the pH value of a neutral solution?", "7", "0", "14", "5", "7"));
                list.add(new QuizModel("Which gas is responsible for the 'greenhouse effect' and climate change?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("Which element is commonly used in nuclear reactors as a fuel?", "Uranium", "Plutonium", "Thorium", "Neptunium", "Uranium"));
                list.add(new QuizModel("What is the chemical formula for table salt?", "Na2SO4", "HCl", "NaCl", "H2SO4", "NaCl"));
                list.add(new QuizModel("Which gas gives fizzy drinks their bubbles?", "Oxygen", "Nitrogen", "Carbon dioxide", "Helium", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical symbol for lead?", "Pd", "Li", "Le", "Pb", "Pb"));

                setup();
                break;

            case "Chemistry Test 2":

                list.add(new QuizModel("Which element is the most abundant in the universe?", "Hydrogen", "Helium", "Oxygen", "Carbon", "Hydrogen"));
                list.add(new QuizModel("What is the chemical symbol for potassium?", "K", "P", "Ko", "Po", "K"));
                list.add(new QuizModel("Which gas is produced by plants during photosynthesis?", "Oxygen", "Carbon dioxide", "Methane", "Nitrogen", "Oxygen"));
                list.add(new QuizModel("What is the chemical formula for glucose?", "C6H12O6", "H2O2", "CO2", "CH4", "C6H12O6"));
                list.add(new QuizModel("Which element is a noble gas used in lighting and signs?", "Neon", "Argon", "Krypton", "Xenon", "Neon"));
                list.add(new QuizModel("What is the chemical symbol for sodium?", "Sa", "So", "Na", "No", "Na"));
                list.add(new QuizModel("Which gas is known as 'laughing gas'?", "Methane", "Nitrogen", "Carbon dioxide", "Nitrous oxide", "Nitrous oxide"));
                list.add(new QuizModel("What is the chemical formula for carbon dioxide?", "CO", "CO2", "C2O", "C2O4", "CO2"));
                list.add(new QuizModel("Which element is a major component of Earth's atmosphere?", "Oxygen", "Carbon", "Argon", "Nitrogen", "Nitrogen"));
                list.add(new QuizModel("What is the chemical symbol for chlorine?", "Cl", "Cn", "Ch", "Ce", "Cl"));
                list.add(new QuizModel("Which gas is produced by the burning of fossil fuels and contributes to air pollution?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical formula for hydrogen peroxide?", "H2O2", "H2O", "HO2", "H2O3", "H2O2"));
                list.add(new QuizModel("Which element is commonly used in batteries?", "Lithium", "Sodium", "Potassium", "Rubidium", "Lithium"));
                list.add(new QuizModel("What is the chemical symbol for helium?", "He", "H", "Hi", "Hu", "He"));
                list.add(new QuizModel("Which gas is responsible for the blue color of the Earth's sky?", "Oxygen", "Carbon dioxide", "Nitrogen", "Ozone", "Nitrogen"));

                setup();
                break;

            case "Chemistry Test 3":

                list.add(new QuizModel("What is the chemical formula for methane?", "CH3", "CO2", "H2O", "NH3", "CH4"));
                list.add(new QuizModel("Which element is a metal often used in electrical wiring?", "Copper", "Aluminum", "Silver", "Gold", "Copper"));
                list.add(new QuizModel("What is the chemical symbol for nitrogen?", "N", "Ni", "No", "Ne", "N"));
                list.add(new QuizModel("Which gas is used by plants in photosynthesis?", "Oxygen", "Carbon dioxide", "Methane", "Hydrogen", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical formula for carbon monoxide?", "CO2", "H2O", "CO", "CH4", "CO"));
                list.add(new QuizModel("Which element is a noble gas used in neon signs?", "Neon", "Argon", "Krypton", "Xenon", "Neon"));
                list.add(new QuizModel("What is the atomic number of hydrogen?", "0", "1", "2", "3", "1"));
                list.add(new QuizModel("Which element has the symbol 'Fe'?", "Iron", "Iodine", "Indium", "Iridium", "Iron"));
                list.add(new QuizModel("What is the chemical formula for sulfuric acid?", "HCl", "H2O", "SO2", "H2SO4", "H2SO4"));
                list.add(new QuizModel("Which gas is used in balloons to make them float?", "Helium", "Hydrogen", "Oxygen", "Nitrogen", "Helium"));
                list.add(new QuizModel("What is the chemical symbol for carbon?", "Ca", "Cr", "Co", "C", "C"));
                list.add(new QuizModel("What is the chemical formula for ammonia?", "NH3", "N2O", "CO2", "H2O", "NH3"));
                list.add(new QuizModel("Which gas is commonly used in fire extinguishers to suppress fires?", "Oxygen", "Carbon dioxide", "Nitrogen", "Argon", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical formula for carbon tetrachloride?", "CCl4", "CH4", "CO2", "H2O", "CCl4"));
                list.add(new QuizModel("Which element is a gas that is essential for respiration?", "Oxygen", "Hydrogen", "Carbon", "Nitrogen", "Oxygen"));

                setup();
                break;

            case "Chemistry Test 4":

                list.add(new QuizModel("What is the chemical symbol for oxygen?", "Ox", "Oy", "Oz", "O", "O"));
                list.add(new QuizModel("Which gas is commonly used in fire extinguishers to suppress fires?", "Oxygen", "Carbon dioxide", "Nitrogen", "Argon", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical formula for carbon tetrachloride?", "CCl4", "CH4", "CO2", "H2O", "CCl4"));
                list.add(new QuizModel("Which element is a gas that is essential for respiration?", "Oxygen", "Hydrogen", "Carbon", "Nitrogen", "Oxygen"));
                list.add(new QuizModel("What is the chemical symbol for potassium?", "K", "P", "Ko", "Po", "K"));
                list.add(new QuizModel("Which gas is known as 'laughing gas'?", "Methane", "Nitrogen", "Carbon dioxide", "Nitrous oxide", "Nitrous oxide"));
                list.add(new QuizModel("What is the chemical formula for carbon dioxide?", "CO", "CO2", "C2O", "C2O4", "CO2"));
                list.add(new QuizModel("Which element is a major component of Earth's atmosphere?", "Oxygen", "Carbon", "Argon", "Nitrogen", "Nitrogen"));
                list.add(new QuizModel("What is the chemical symbol for chlorine?", "Cl", "Cn", "Ch", "Ce", "Cl"));
                list.add(new QuizModel("Which gas is produced by the burning of fossil fuels and contributes to air pollution?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical formula for hydrogen peroxide?", "H2O2", "H2O", "HO2", "H2O3", "H2O2"));
                list.add(new QuizModel("Which element is commonly used in batteries?", "Lithium", "Sodium", "Potassium", "Rubidium", "Lithium"));
                list.add(new QuizModel("What is the chemical symbol for helium?", "He", "H", "Hi", "Hu", "He"));
                list.add(new QuizModel("Which gas is responsible for the blue color of the Earth's sky?", "Oxygen", "Carbon dioxide", "Nitrogen", "Ozone", "Nitrogen"));
                list.add(new QuizModel("What is the chemical formula for methane?", "CH3", "CO2", "H2O", "NH3", "CH4"));

                setup();
                break;

            case "Chemistry Test 5":
                list.add(new QuizModel("Which gas is commonly used in fire extinguishers to suppress fires?", "Oxygen", "Carbon dioxide", "Nitrogen", "Argon", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical formula for carbon tetrachloride?", "CCl4", "CH4", "CO2", "H2O", "CCl4"));
                list.add(new QuizModel("Which element is a gas that is essential for respiration?", "Oxygen", "Hydrogen", "Carbon", "Nitrogen", "Oxygen"));
                list.add(new QuizModel("What is the chemical symbol for potassium?", "K", "P", "Ko", "Po", "K"));
                list.add(new QuizModel("Which gas is known as 'laughing gas'?", "Methane", "Nitrogen", "Carbon dioxide", "Nitrous oxide", "Nitrous oxide"));
                list.add(new QuizModel("What is the chemical formula for carbon dioxide?", "CO", "CO2", "C2O", "C2O4", "CO2"));
                list.add(new QuizModel("Which element is a major component of Earth's atmosphere?", "Oxygen", "Carbon", "Argon", "Nitrogen", "Nitrogen"));
                list.add(new QuizModel("What is the chemical symbol for chlorine?", "Cl", "Cn", "Ch", "Ce", "Cl"));
                list.add(new QuizModel("Which gas is produced by the burning of fossil fuels and contributes to air pollution?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical formula for hydrogen peroxide?", "H2O2", "H2O", "HO2", "H2O3", "H2O2"));
                list.add(new QuizModel("Which element is commonly used in batteries?", "Lithium", "Sodium", "Potassium", "Rubidium", "Lithium"));
                list.add(new QuizModel("What is the chemical symbol for helium?", "He", "H", "Hi", "Hu", "He"));
                list.add(new QuizModel("Which gas is responsible for the blue color of the Earth's sky?", "Oxygen", "Carbon dioxide", "Nitrogen", "Ozone", "Nitrogen"));
                list.add(new QuizModel("What is the chemical formula for methane?", "CH3", "CO2", "H2O", "NH3", "CH4"));
                list.add(new QuizModel("Which element is a metal often used in electrical wiring?", "Copper", "Aluminum", "Silver", "Gold", "Copper"));


                setup();
                break;

            case "Chemistry Test 6":

                list.add(new QuizModel("What is the chemical formula for carbon tetrachloride?", "CCl4", "CH4", "CO2", "H2O", "CCl4"));
                list.add(new QuizModel("Which element is a gas that is essential for respiration?", "Oxygen", "Hydrogen", "Carbon", "Nitrogen", "Oxygen"));
                list.add(new QuizModel("What is the chemical symbol for potassium?", "K", "P", "Ko", "Po", "K"));
                list.add(new QuizModel("Which gas is known as 'laughing gas'?", "Methane", "Nitrogen", "Carbon dioxide", "Nitrous oxide", "Nitrous oxide"));
                list.add(new QuizModel("What is the chemical formula for carbon dioxide?", "CO", "CO2", "C2O", "C2O4", "CO2"));
                list.add(new QuizModel("Which element is a major component of Earth's atmosphere?", "Oxygen", "Carbon", "Argon", "Nitrogen", "Nitrogen"));
                list.add(new QuizModel("What is the chemical symbol for chlorine?", "Cl", "Cn", "Ch", "Ce", "Cl"));
                list.add(new QuizModel("Which gas is produced by the burning of fossil fuels and contributes to air pollution?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical formula for hydrogen peroxide?", "H2O2", "H2O", "HO2", "H2O3", "H2O2"));
                list.add(new QuizModel("Which element is commonly used in batteries?", "Lithium", "Sodium", "Potassium", "Rubidium", "Lithium"));
                list.add(new QuizModel("What is the chemical symbol for helium?", "He", "H", "Hi", "Hu", "He"));
                list.add(new QuizModel("Which gas is responsible for the blue color of the Earth's sky?", "Oxygen", "Carbon dioxide", "Nitrogen", "Ozone", "Nitrogen"));
                list.add(new QuizModel("What is the chemical formula for methane?", "CH3", "CO2", "H2O", "NH3", "CH4"));
                list.add(new QuizModel("Which element is a metal often used in electrical wiring?", "Copper", "Aluminum", "Silver", "Gold", "Copper"));
                list.add(new QuizModel("What is the chemical symbol for nitrogen?", "N", "Ni", "No", "Ne", "N"));

                setup();
                break;

            case "Chemistry Test 7":
                list.add(new QuizModel("Which element is a gas that is essential for respiration?", "Oxygen", "Hydrogen", "Carbon", "Nitrogen", "Oxygen"));
                list.add(new QuizModel("What is the chemical symbol for potassium?", "K", "P", "Ko", "Po", "K"));
                list.add(new QuizModel("Which gas is known as 'laughing gas'?", "Methane", "Nitrogen", "Carbon dioxide", "Nitrous oxide", "Nitrous oxide"));
                list.add(new QuizModel("What is the chemical formula for carbon dioxide?", "CO", "CO2", "C2O", "C2O4", "CO2"));
                list.add(new QuizModel("Which element is a major component of Earth's atmosphere?", "Oxygen", "Carbon", "Argon", "Nitrogen", "Nitrogen"));
                list.add(new QuizModel("What is the chemical symbol for chlorine?", "Cl", "Cn", "Ch", "Ce", "Cl"));
                list.add(new QuizModel("Which gas is produced by the burning of fossil fuels and contributes to air pollution?", "Oxygen", "Carbon dioxide", "Nitrogen", "Methane", "Carbon dioxide"));
                list.add(new QuizModel("What is the chemical formula for hydrogen peroxide?", "H2O2", "H2O", "HO2", "H2O3", "H2O2"));
                list.add(new QuizModel("Which element is commonly used in batteries?", "Lithium", "Sodium", "Potassium", "Rubidium", "Lithium"));
                list.add(new QuizModel("What is the chemical symbol for helium?", "He", "H", "Hi", "Hu", "He"));
                list.add(new QuizModel("Which gas is responsible for the blue color of the Earth's sky?", "Oxygen", "Carbon dioxide", "Nitrogen", "Ozone", "Nitrogen"));
                list.add(new QuizModel("What is the chemical formula for methane?", "CH3", "CO2", "H2O", "NH3", "CH4"));
                list.add(new QuizModel("Which element is a metal often used in electrical wiring?", "Copper", "Aluminum", "Silver", "Gold", "Copper"));
                list.add(new QuizModel("What is the chemical symbol for nitrogen?", "N", "Ni", "No", "Ne", "N"));
                list.add(new QuizModel("Which gas is used by plants in photosynthesis?", "Oxygen", "Carbon dioxide", "Methane", "Hydrogen", "Carbon dioxide"));

                setup();
                break;

                // Chemistry ended


            // Reasoning Start


            case "Reasoning Test 1":

                list.add(new QuizModel("What comes next in the sequence: 2, 4, 8, 16, ?", "32", "64", "24", "48", "32"));
                list.add(new QuizModel("Which of the following is a synonym for 'intelligent'?", "Smart", "Dumb", "Happy", "Angry", "Smart"));
                list.add(new QuizModel("If all Zips are Zaps, and some Zaps are Zops, then some Zips are definitely Zops. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));
                list.add(new QuizModel("What comes next in the series: 3, 6, 9, 12, ?", "15", "18", "21", "24", "15"));
                list.add(new QuizModel("If CAT is coded as 312, how is DOG coded?", "415", "413", "412", "512", "413"));
                list.add(new QuizModel("If RED is coded as 27, how is BLUE coded?", "50", "49", "48", "47", "48"));
                list.add(new QuizModel("If 8 + 3 = 24, 7 + 2 = 63, 6 + 5 = 66, then 9 + 4 = ?", "96", "84", "69", "36", "96"));
                list.add(new QuizModel("What comes next in the sequence: 5, 10, 15, 20, ?", "25", "30", "35", "40", "25"));
                list.add(new QuizModel("If all roses are flowers, and some flowers fade quickly, then some roses fade quickly. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));
                list.add(new QuizModel("Which word does not belong in this group: apple, banana, cherry, grape, potato?", "Potato", "Apple", "Banana", "Cherry", "Potato"));
                list.add(new QuizModel("If 3 cats catch 3 mice in 3 minutes, how many cats are needed to catch 100 mice in 100 minutes?", "100", "33", "3", "1", "3"));
                list.add(new QuizModel("If APPLE is coded as 901662, how is ORANGE coded?", "911667", "921673", "913668", "901664", "921673"));
                list.add(new QuizModel("If 12 + 13 = 15, 25 + 30 = 35, 60 + 10 = 65, then 45 + 18 = ?", "53", "60", "63", "65", "63"));
                list.add(new QuizModel("What comes next in the sequence: 1, 3, 6, 10, ?", "15", "16", "18", "21", "15"));
                list.add(new QuizModel("If all doctors are smart, and some smart people are rich, then some doctors are rich. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));

                setup();
                break;

            case "Reasoning Test 2":

                list.add(new QuizModel("What comes next in the series: 7, 14, 21, 28, ?", "35", "36", "42", "49", "35"));
                list.add(new QuizModel("If RED is coded as 5, BLUE is coded as 12, and GREEN is coded as 7, what is the code for YELLOW?", "7", "8", "10", "11", "8"));
                list.add(new QuizModel("Which of the following does not belong in this group: triangle, square, circle, hexagon, rectangle?", "Circle", "Triangle", "Square", "Rectangle", "Circle"));
                list.add(new QuizModel("If 3 cats catch 3 mice in 3 minutes, how many cats are needed to catch 300 mice in 300 minutes?", "100", "300", "3", "1", "3"));
                list.add(new QuizModel("If BARK is coded as 21910, how is BITE coded?", "9182", "2183", "2918", "1829", "9182"));
                list.add(new QuizModel("What comes next in the sequence: 10, 9, 7, 4, ?", "0", "1", "2", "3", "0"));
                list.add(new QuizModel("If DOG is coded as 415, how is CAT coded?", "915", "413", "412", "512", "915"));
                list.add(new QuizModel("If 5 + 8 = 13, 12 + 14 = 26, 18 + 10 = 28, then 6 + 9 = ?", "15", "16", "17", "18", "15"));
                list.add(new QuizModel("What comes next in the series: 20, 22, 25, 29, ?", "30", "31", "32", "33", "33"));
                list.add(new QuizModel("If all books are pages, and some pages are words, then some books are words. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));
                list.add(new QuizModel("Which word does not belong in this group: car, bicycle, motorcycle, boat, airplane?", "Airplane", "Car", "Bicycle", "Boat", "Airplane"));
                list.add(new QuizModel("If 4 pencils cost $2, how much do 12 pencils cost?", "$3", "$4", "$6", "$8", "$6"));
                list.add(new QuizModel("If YELLOW is coded as 574832, how is GREEN coded?", "784203", "985714", "625837", "347896", "784203"));
                list.add(new QuizModel("What comes next in the sequence: 3, 9, 27, 81, ?", "243", "324", "128", "256", "243"));
                list.add(new QuizModel("If APPLE is coded as 25, how is GRAPE coded?", "30", "22", "27", "28", "27"));

                setup();
                break;

            case "Reasoning Test 3":

                list.add(new QuizModel("If 6 + 7 = 13, 13 + 8 = 21, 21 + 9 = 30, then 7 + 10 = ?", "20", "29", "31", "37", "29"));
                list.add(new QuizModel("What comes next in the sequence: 2, 6, 18, 54, ?", "162", "216", "324", "486", "162"));
                list.add(new QuizModel("If PENCIL is coded as 728954, how is ERASER coded?", "691785", "697154", "876195", "745896", "697154"));
                list.add(new QuizModel("Which word does not belong in this group: apple, orange, banana, grape, tomato?", "Grape", "Apple", "Orange", "Banana", "Tomato"));
                list.add(new QuizModel("If 3 dogs catch 3 balls in 3 minutes, how many dogs are needed to catch 30 balls in 30 minutes?", "10", "30", "3", "1", "3"));
                list.add(new QuizModel("What comes next in the series: 10, 20, 30, 40, ?", "50", "60", "70", "80", "50"));
                list.add(new QuizModel("If 4 + 9 = 13, 8 + 16 = 24, 12 + 25 = 37, then 6 + 12 = ?", "18", "24", "27", "30", "18"));
                list.add(new QuizModel("If all squares are rectangles, and some rectangles are blue, then some squares are blue. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));
                list.add(new QuizModel("Which of the following is an antonym for 'fast'?", "Quick", "Speedy", "Slow", "Rapid", "Slow"));
                list.add(new QuizModel("If 2 pizzas cost $12, how much do 6 pizzas cost?", "$18", "$20", "$24", "$36", "$36"));
                list.add(new QuizModel("What comes next in the sequence: 5, 25, 125, 625, ?", "3125", "1250", "2500", "6250", "3125"));
                list.add(new QuizModel("If TABLE is coded as 713945, how is CHAIR coded?", "317149", "159734", "713941", "317159", "317149"));
                list.add(new QuizModel("Which word does not belong in this group: violin, piano, guitar, trumpet, bicycle?", "Bicycle", "Violin", "Piano", "Guitar", "Bicycle"));
                list.add(new QuizModel("If 5 dogs catch 5 balls in 5 minutes, how many dogs are needed to catch 50 balls in 50 minutes?", "10", "50", "5", "1", "5"));
                list.add(new QuizModel("What comes next in the series: 1, 2, 4, 8, ?", "12", "16", "18", "32", "16"));

                setup();
                break;

            case "Reasoning Test 4":

                list.add(new QuizModel("If 4 + 6 = 10, 10 + 12 = 22, 16 + 18 = 34, then 6 + 8 = ?", "18", "26", "28", "36", "18"));
                list.add(new QuizModel("What comes next in the sequence: 5, 10, 20, 40, ?", "80", "100", "120", "160", "80"));
                list.add(new QuizModel("If APPLE is coded as 91180, how is BANANA coded?", "291124", "725718", "138316", "118017", "725718"));
                list.add(new QuizModel("Which word does not belong in this group: cow, horse, chicken, sheep, car?", "Car", "Cow", "Horse", "Chicken", "Car"));
                list.add(new QuizModel("If 8 dogs catch 8 balls in 8 minutes, how many dogs are needed to catch 64 balls in 64 minutes?", "8", "64", "32", "16", "8"));
                list.add(new QuizModel("What comes next in the series: 3, 9, 27, 81, ?", "243", "324", "128", "256", "243"));
                list.add(new QuizModel("If ORANGE is coded as 617924, how is LEMON coded?", "365210", "462018", "926470", "617920", "365210"));
                list.add(new QuizModel("Which of the following is an antonym for 'brave'?", "Cowardly", "Fearless", "Valiant", "Courageous", "Cowardly"));
                list.add(new QuizModel("If 3 + 5 = 11, 6 + 7 = 15, 4 + 8 = 13, then 5 + 9 = ?", "12", "14", "15", "16", "14"));
                list.add(new QuizModel("What comes next in the sequence: 2, 6, 18, 54, ?", "162", "216", "324", "486", "162"));
                list.add(new QuizModel("If APPLE is coded as 57, how is MANGO coded?", "68", "70", "64", "63", "68"));
                list.add(new QuizModel("If 10 + 3 = 70, 5 + 8 = 46, 2 + 7 = 21, then 6 + 5 = ?", "36", "26", "19", "11", "26"));
                list.add(new QuizModel("What comes next in the series: 1, 4, 9, 16, ?", "25", "36", "49", "64", "25"));
                list.add(new QuizModel("If all roses are flowers, and some flowers are red, then some roses are red. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));
                list.add(new QuizModel("Which of the following is a synonym for 'friendly'?", "Hostile", "Amiable", "Aggressive", "Harsh", "Amiable"));

                setup();
                break;

            case "Reasoning Test 5":
                list.add(new QuizModel("What comes next in the sequence: 2, 4, 8, 16, ?", "32", "64", "24", "48", "32"));
                list.add(new QuizModel("If all Zips are Zaps, and some Zaps are Zops, then some Zips are definitely Zops. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));
                list.add(new QuizModel("Which word does not belong in this group: apple, banana, cherry, grape, potato?", "Potato", "Apple", "Banana", "Cherry", "Potato"));
                list.add(new QuizModel("If 3 cats catch 3 mice in 3 minutes, how many cats are needed to catch 100 mice in 100 minutes?", "100", "33", "3", "1", "3"));
                list.add(new QuizModel("What comes next in the series: 3, 6, 9, 12, ?", "15", "16", "18", "21", "15"));
                list.add(new QuizModel("If CAT is coded as 312, how is DOG coded?", "415", "413", "412", "512", "413"));
                list.add(new QuizModel("If RED is coded as 27, BLUE is coded as 39, and GREEN is coded as 45, what is the code for YELLOW?", "57", "54", "60", "62", "57"));
                list.add(new QuizModel("If 8 + 3 = 24, 7 + 2 = 63, 6 + 5 = 66, then 9 + 4 = ?", "96", "84", "69", "36", "96"));
                list.add(new QuizModel("What comes next in the sequence: 1, 3, 6, 10, ?", "15", "16", "18", "21", "15"));
                list.add(new QuizModel("If all roses are flowers, and some flowers fade quickly, then some roses fade quickly. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));
                list.add(new QuizModel("Which of the following does not belong in this group: triangle, square, circle, hexagon, rectangle?", "Circle", "Triangle", "Square", "Rectangle", "Circle"));
                list.add(new QuizModel("If 3 dogs catch 3 balls in 3 minutes, how many dogs are needed to catch 300 balls in 300 minutes?", "100", "300", "3", "1", "3"));
                list.add(new QuizModel("What comes next in the series: 20, 22, 25, 29, ?", "30", "31", "32", "33", "33"));
                list.add(new QuizModel("If all doctors are smart, and some smart people are rich, then some doctors are rich. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));
                list.add(new QuizModel("Which word does not belong in this group: apple, orange, banana, grape, tomato?", "Grape", "Apple", "Orange", "Banana", "Tomato"));

                setup();
                break;

            case "Reasoning Test 6":

                list.add(new QuizModel("What comes next in the series: 7, 14, 21, 28, ?", "35", "36", "42", "49", "35"));
                list.add(new QuizModel("If DOG is coded as 415, how is CAT coded?", "915", "413", "412", "512", "915"));
                list.add(new QuizModel("If 5 + 8 = 13, 12 + 14 = 26, 18 + 10 = 28, then 45 + 18 = ?", "53", "60", "63", "65", "63"));
                list.add(new QuizModel("What comes next in the sequence: 10, 20, 30, 40, ?", "50", "60", "70", "80", "50"));
                list.add(new QuizModel("If APPLE is coded as 901662, how is BANANA coded?", "911667", "921673", "913668", "901664", "921673"));
                list.add(new QuizModel("Which word does not belong in this group: cow, horse, chicken, sheep, car?", "Car", "Cow", "Horse", "Chicken", "Car"));
                list.add(new QuizModel("If 3 dogs catch 3 balls in 3 minutes, how many dogs are needed to catch 30 balls in 30 minutes?", "10", "30", "3", "1", "3"));
                list.add(new QuizModel("What comes next in the series: 1, 2, 4, 8, ?", "12", "16", "18", "32", "16"));
                list.add(new QuizModel("If 3 + 4 = 12, 6 + 8 = 48, 9 + 12 = 108, then 7 + 10 = ?", "72", "84", "120", "132", "84"));
                list.add(new QuizModel("What comes next in the sequence: 2, 6, 18, 54, ?", "162", "216", "324", "486", "162"));
                list.add(new QuizModel("If APPLE is coded as 25, how is GRAPE coded?", "30", "22", "27", "28", "27"));
                list.add(new QuizModel("If 10 + 5 = 50, 15 + 10 = 150, 20 + 15 = 300, then 25 + 20 = ?", "500", "600", "750", "1000", "500"));
                list.add(new QuizModel("What comes next in the sequence: 1, 4, 9, 16, ?", "25", "36", "49", "64", "25"));
                list.add(new QuizModel("If all lions are cats, and some cats are black, then some lions are black. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));
                list.add(new QuizModel("Which of the following is a synonym for 'happy'?", "Joyful", "Sad", "Excited", "Angry", "Joyful"));

                setup();
                break;

            case "Reasoning Test 7":

                list.add(new QuizModel("If YELLOW is coded as 574832, how is GREEN coded?", "784203", "985714", "625837", "347896", "784203"));
                list.add(new QuizModel("What comes next in the series: 7, 14, 21, 28, ?", "35", "36", "42", "49", "35"));
                list.add(new QuizModel("If DOG is coded as 415, how is CAT coded?", "915", "413", "412", "512", "915"));
                list.add(new QuizModel("If 5 + 8 = 13, 12 + 14 = 26, 18 + 10 = 28, then 45 + 18 = ?", "53", "60", "63", "65", "63"));
                list.add(new QuizModel("What comes next in the sequence: 10, 20, 30, 40, ?", "50", "60", "70", "80", "50"));
                list.add(new QuizModel("If APPLE is coded as 901662, how is BANANA coded?", "911667", "921673", "913668", "901664", "921673"));
                list.add(new QuizModel("Which word does not belong in this group: cow, horse, chicken, sheep, car?", "Car", "Cow", "Horse", "Chicken", "Car"));
                list.add(new QuizModel("If 3 dogs catch 3 balls in 3 minutes, how many dogs are needed to catch 30 balls in 30 minutes?", "10", "30", "3", "1", "3"));
                list.add(new QuizModel("What comes next in the series: 1, 2, 4, 8, ?", "12", "16", "18", "32", "16"));
                list.add(new QuizModel("If 3 + 4 = 12, 6 + 8 = 48, 9 + 12 = 108, then 7 + 10 = ?", "72", "84", "120", "132", "84"));
                list.add(new QuizModel("What comes next in the sequence: 2, 6, 18, 54, ?", "162", "216", "324", "486", "162"));
                list.add(new QuizModel("If APPLE is coded as 25, how is GRAPE coded?", "30", "22", "27", "28", "27"));
                list.add(new QuizModel("If 10 + 5 = 50, 15 + 10 = 150, 20 + 15 = 300, then 25 + 20 = ?", "500", "600", "750", "1000", "500"));
                list.add(new QuizModel("What comes next in the sequence: 1, 4, 9, 16, ?", "25", "36", "49", "64", "25"));
                list.add(new QuizModel("If all lions are cats, and some cats are black, then some lions are black. Is this statement true or false?", "True", "False", "Cannot be determined", "Neither true nor false", "True"));

                setup();
                break;

            // Reasoning ended

            // English Start


            case "English Test 1":

                list.add(new QuizModel("Which of these lies between 6.3 and 6.6?", "6.41", "9.41", "3.41", "5.41", "6.41"));
                list.add(new QuizModel("What is the plural form of 'child'?", "children", "childs", "childen", "child's", "children"));
                list.add(new QuizModel("Choose the correct spelling:", "necessary", "neccessary", "necesary", "nessessary", "necessary"));
                list.add(new QuizModel("What is the opposite of 'brave'?", "cowardly", "strong", "fearless", "bold", "cowardly"));
                list.add(new QuizModel("Which word is a synonym for 'happy'?", "joyful", "sad", "excited", "angry", "joyful"));
                list.add(new QuizModel("What does the acronym 'NASA' stand for?", "National Aeronautics and Space Administration", "National Aviation and Space Association", "North American Space Agency", "New Aerospace and Space Association", "National Aeronautics and Space Administration"));
                list.add(new QuizModel("Which of these is a type of fruit?", "banana", "carrot", "potato", "broccoli", "banana"));
                list.add(new QuizModel("What is the past tense of 'sing'?", "sung", "sing", "song", "sang", "sang"));
                list.add(new QuizModel("Choose the correct sentence:", "She had went to the store.", "She have gone to the store.", "She has went to the store.", "She had gone to the store.", "She had gone to the store."));
                list.add(new QuizModel("Which of the following is an adverb?", "quickly", "happy", "table", "cat", "quickly"));
                list.add(new QuizModel("What is the superlative form of 'good'?", "better", "best", "well", "goodest", "best"));
                list.add(new QuizModel("What is the plural of 'mouse'?", "mouses", "mice", "mouse", "mousen", "mice"));
                list.add(new QuizModel("Choose the correct spelling:", "occurred", "ocurred", "ocured", "occurd", "occurred"));
                list.add(new QuizModel("What is the opposite of 'victory'?", "defeat", "success", "triumph", "achievement", "defeat"));
                list.add(new QuizModel("Which of these is an example of a conjunction?", "and", "run", "blue", "jump", "and"));

                setup();
                break;

            case "English Test 2":

                list.add(new QuizModel("Which of the following is a preposition?", "under", "sing", "book", "run", "under"));
                list.add(new QuizModel("What is the plural of 'knife'?", "knifes", "knive", "knives", "knifs", "knives"));
                list.add(new QuizModel("Choose the correct spelling:", "receive", "recieve", "receeve", "recive", "receive"));
                list.add(new QuizModel("What is the opposite of 'generous'?", "selfish", "kind", "giving", "charitable", "selfish"));
                list.add(new QuizModel("Which of these is a type of weather?", "cloudy", "table", "cat", "jump", "cloudy"));
                list.add(new QuizModel("What is the past tense of 'write'?", "writed", "writ", "wrote", "written", "wrote"));
                list.add(new QuizModel("Choose the correct sentence:", "They is going to the party.", "They are going to the party.", "They have going to the party.", "They go to the party.", "They are going to the party."));
                list.add(new QuizModel("Which of the following is an adjective?", "happy", "quickly", "run", "and", "happy"));
                list.add(new QuizModel("What is the superlative form of 'fast'?", "faster", "fastest", "more fast", "fastier", "fastest"));
                list.add(new QuizModel("What is the plural of 'leaf'?", "leafs", "leave", "leaves", "leafes", "leaves"));
                list.add(new QuizModel("Choose the correct spelling:", "separate", "seperete", "seperate", "sepperate", "separate"));
                list.add(new QuizModel("What is the opposite of 'patient'?", "impatient", "tolerant", "understanding", "calm", "impatient"));
                list.add(new QuizModel("Which word is a synonym for 'small'?", "tiny", "big", "huge", "large", "tiny"));
                list.add(new QuizModel("What does the acronym 'UNICEF' stand for?", "United Nations International Children's Emergency Fund", "Universal Network for International Child Education and Family", "United Nations Intercontinental Children's Education Foundation", "Universal Network for Inclusive Child Education and Families", "United Nations International Children's Emergency Fund"));
                list.add(new QuizModel("Which of these is a type of flower?", "book", "table", "cat", "rose", "rose"));

                setup();
                break;

            case "English Test 3":
                list.add(new QuizModel("What is the comparative form of 'good'?", "better", "best", "well", "goodest", "better"));
                list.add(new QuizModel("What is the plural of 'child'?", "children", "childs", "childen", "child's", "children"));
                list.add(new QuizModel("Choose the correct spelling:", "necessary", "neccessary", "necesary", "nessessary", "necessary"));
                list.add(new QuizModel("What is the opposite of 'brave'?", "cowardly", "strong", "fearless", "bold", "cowardly"));
                list.add(new QuizModel("Which word is a synonym for 'happy'?", "joyful", "sad", "excited", "angry", "joyful"));
                list.add(new QuizModel("What does the acronym 'NASA' stand for?", "National Aeronautics and Space Administration", "National Aviation and Space Association", "North American Space Agency", "New Aerospace and Space Association", "National Aeronautics and Space Administration"));
                list.add(new QuizModel("Which of these is a type of fruit?", "banana", "carrot", "potato", "broccoli", "banana"));
                list.add(new QuizModel("What is the past tense of 'sing'?", "sung", "sing", "song", "sang", "sang"));
                list.add(new QuizModel("Choose the correct sentence:", "He don't like pizza.", "He doesn't like pizza.", "He not like pizza.", "He do not like pizza.", "He doesn't like pizza."));
                list.add(new QuizModel("What is the superlative form of 'good'?", "better", "best", "well", "goodest", "best"));
                list.add(new QuizModel("What is the plural of 'mouse'?", "mouses", "mice", "mouse", "mousen", "mice"));
                list.add(new QuizModel("Choose the correct spelling:", "occurred", "ocurred", "ocured", "occurd", "occurred"));
                list.add(new QuizModel("What is the opposite of 'victory'?", "defeat", "success", "triumph", "achievement", "defeat"));
                list.add(new QuizModel("Which of these is an example of a conjunction?", "and", "run", "blue", "jump", "and"));
                list.add(new QuizModel("What is the present participle of 'run'?", "ran", "running", "runs", "runned", "running"));

                setup();
                break;

            case "English Test 4":

                list.add(new QuizModel("Choose the correct spelling:", "receive", "recieve", "receeve", "recive", "receive"));
                list.add(new QuizModel("What is the opposite of 'generous'?", "selfish", "kind", "giving", "charitable", "selfish"));
                list.add(new QuizModel("Which of these is a type of weather?", "cloudy", "table", "cat", "jump", "cloudy"));
                list.add(new QuizModel("What is the past tense of 'write'?", "writed", "writ", "wrote", "written", "wrote"));
                list.add(new QuizModel("Choose the correct sentence:", "They is going to the party.", "They are going to the party.", "They have going to the party.", "They go to the party.", "They are going to the party."));
                list.add(new QuizModel("What is the present participle of 'run'?", "ran", "running", "runs", "runned", "running"));
                list.add(new QuizModel("Which of the following is an adjective?", "happy", "quickly", "run", "and", "happy"));
                list.add(new QuizModel("What is the superlative form of 'fast'?", "faster", "fastest", "more fast", "fastier", "fastest"));
                list.add(new QuizModel("What is the plural of 'leaf'?", "leafs", "leave", "leaves", "leafes", "leaves"));
                list.add(new QuizModel("Choose the correct spelling:", "separate", "seperete", "seperate", "sepperate", "separate"));
                list.add(new QuizModel("What is the opposite of 'patient'?", "impatient", "tolerant", "understanding", "calm", "impatient"));
                list.add(new QuizModel("Which word is a synonym for 'small'?", "tiny", "big", "huge", "large", "tiny"));
                list.add(new QuizModel("What does the acronym 'UNICEF' stand for?", "United Nations International Children's Emergency Fund", "Universal Network for International Child Education and Family", "United Nations Intercontinental Children's Education Foundation", "Universal Network for Inclusive Child Education and Families", "United Nations International Children's Emergency Fund"));
                list.add(new QuizModel("Which of these is a type of flower?", "book", "table", "cat", "rose", "rose"));
                list.add(new QuizModel("What is the past tense of 'swim'?", "swam", "swim", "swum", "swimed", "swam"));

                setup();
                break;

            case "English Test 5":

                list.add(new QuizModel("What is the plural of 'child'?", "children", "childs", "childen", "child's", "children"));
                list.add(new QuizModel("Choose the correct spelling:", "necessary", "neccessary", "necesary", "nessessary", "necessary"));
                list.add(new QuizModel("What is the opposite of 'brave'?", "cowardly", "strong", "fearless", "bold", "cowardly"));
                list.add(new QuizModel("Which word is a synonym for 'happy'?", "joyful", "sad", "excited", "angry", "joyful"));
                list.add(new QuizModel("What does the acronym 'NASA' stand for?", "National Aeronautics and Space Administration", "National Aviation and Space Association", "North American Space Agency", "New Aerospace and Space Association", "National Aeronautics and Space Administration"));
                list.add(new QuizModel("Which of these is a type of fruit?", "banana", "carrot", "potato", "broccoli", "banana"));
                list.add(new QuizModel("What is the past tense of 'sing'?", "sung", "sing", "song", "sang", "sang"));
                list.add(new QuizModel("Choose the correct sentence:", "He don't like pizza.", "He doesn't like pizza.", "He not like pizza.", "He do not like pizza.", "He doesn't like pizza."));
                list.add(new QuizModel("What is the superlative form of 'good'?", "better", "best", "well", "goodest", "best"));
                list.add(new QuizModel("What is the plural of 'mouse'?", "mouses", "mice", "mouse", "mousen", "mice"));
                list.add(new QuizModel("Choose the correct spelling:", "occurred", "ocurred", "ocured", "occurd", "occurred"));
                list.add(new QuizModel("What is the opposite of 'victory'?", "defeat", "success", "triumph", "achievement", "defeat"));
                list.add(new QuizModel("Which of these is an example of a conjunction?", "and", "run", "blue", "jump", "and"));
                list.add(new QuizModel("What is the present participle of 'run'?", "ran", "running", "runs", "runned", "running"));
                list.add(new QuizModel("Choose the correct sentence:", "He don't like pizza.", "He doesn't like pizza.", "He not like pizza.", "He do not like pizza.", "He doesn't like pizza."));

                setup();
                break;

            case "English Test 6":

                list.add(new QuizModel("What is the opposite of 'generous'?", "selfish", "kind", "giving", "charitable", "selfish"));
                list.add(new QuizModel("Which of these is a type of weather?", "cloudy", "table", "cat", "jump", "cloudy"));
                list.add(new QuizModel("What is the past tense of 'write'?", "writed", "writ", "wrote", "written", "wrote"));
                list.add(new QuizModel("Choose the correct sentence:", "They is going to the party.", "They are going to the party.", "They have going to the party.", "They go to the party.", "They are going to the party."));
                list.add(new QuizModel("What is the present participle of 'run'?", "ran", "running", "runs", "runned", "running"));
                list.add(new QuizModel("Which of the following is an adjective?", "happy", "quickly", "run", "and", "happy"));
                list.add(new QuizModel("What is the superlative form of 'fast'?", "faster", "fastest", "more fast", "fastier", "fastest"));
                list.add(new QuizModel("What is the plural of 'leaf'?", "leafs", "leave", "leaves", "leafes", "leaves"));
                list.add(new QuizModel("Choose the correct spelling:", "separate", "seperete", "seperate", "sepperate", "separate"));
                list.add(new QuizModel("What is the opposite of 'patient'?", "impatient", "tolerant", "understanding", "calm", "impatient"));
                list.add(new QuizModel("Which word is a synonym for 'small'?", "tiny", "big", "huge", "large", "tiny"));
                list.add(new QuizModel("What does the acronym 'UNICEF' stand for?", "United Nations International Children's Emergency Fund", "Universal Network for International Child Education and Family", "United Nations Intercontinental Children's Education Foundation", "Universal Network for Inclusive Child Education and Families", "United Nations International Children's Emergency Fund"));
                list.add(new QuizModel("Which of these is a type of flower?", "book", "table", "cat", "rose", "rose"));
                list.add(new QuizModel("What is the past tense of 'swim'?", "swam", "swim", "swum", "swimed", "swam"));
                list.add(new QuizModel("Choose the correct sentence:", "She have been studying all day.", "She has been studying all day.", "She is studying all day.", "She had studied all day.", "She has been studying all day."));

                setup();
                break;

            case "English Test 7":

                list.add(new QuizModel("Choose the correct spelling:", "necessary", "neccessary", "necesary", "nessessary", "necessary"));
                list.add(new QuizModel("What is the opposite of 'brave'?", "cowardly", "strong", "fearless", "bold", "cowardly"));
                list.add(new QuizModel("Which word is a synonym for 'happy'?", "joyful", "sad", "excited", "angry", "joyful"));
                list.add(new QuizModel("What does the acronym 'NASA' stand for?", "National Aeronautics and Space Administration", "National Aviation and Space Association", "North American Space Agency", "New Aerospace and Space Association", "National Aeronautics and Space Administration"));
                list.add(new QuizModel("Which of these is a type of fruit?", "banana", "carrot", "potato", "broccoli", "banana"));
                list.add(new QuizModel("What is the past tense of 'sing'?", "sung", "sing", "song", "sang", "sang"));
                list.add(new QuizModel("Choose the correct sentence:", "He don't like pizza.", "He doesn't like pizza.", "He not like pizza.", "He do not like pizza.", "He doesn't like pizza."));
                list.add(new QuizModel("What is the superlative form of 'good'?", "better", "best", "well", "goodest", "best"));
                list.add(new QuizModel("What is the plural of 'mouse'?", "mouses", "mice", "mouse", "mousen", "mice"));
                list.add(new QuizModel("Choose the correct spelling:", "occurred", "ocurred", "ocured", "occurd", "occurred"));
                list.add(new QuizModel("What is the opposite of 'victory'?", "defeat", "success", "triumph", "achievement", "defeat"));
                list.add(new QuizModel("Which of these is an example of a conjunction?", "and", "run", "blue", "jump", "and"));
                list.add(new QuizModel("What is the present participle of 'run'?", "ran", "running", "runs", "runned", "running"));
                list.add(new QuizModel("Choose the correct sentence:", "He don't like pizza.", "He doesn't like pizza.", "He not like pizza.", "He do not like pizza.", "He doesn't like pizza."));
                list.add(new QuizModel("What is the comparative form of 'far'?", "farther", "farest", "farrer", "farer", "farther"));

                setup();
                break;

            // Chemistry ended

        }


    }

    private void setup(){

        allQuestion=15;
        listsize=String.valueOf(allQuestion);
        binding.totalquestion.setText("/"+listsize);

        if(position !=allQuestion){
            positionNo=String.valueOf(position+1);
            binding.Qno.setText(positionNo);
        }
        else {
            positionNo=String.valueOf(position);
            binding.Qno.setText(positionNo);
        }

        quizModel=list.get(position);
        answer=quizModel.getCorrectAns();

        binding.questioncon.setText(quizModel.getQuestion());
        binding.option1Con.setText(quizModel.getOp1());
        binding.option2Con.setText(quizModel.getOp2());
        binding.option3Con.setText(quizModel.getOp3());
        binding.option4Con.setText(quizModel.getOp4());

        optionCheckup();

    }
    private void optionCheckup() {
        binding.option1Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.equals(quizModel.getOp1(),quizModel.getCorrectAns())){
                    right++;
                    binding.option1Con.setBackgroundResource(R.drawable.new_right_bg);
                    binding.option1Con.setTextColor(getContext().getColor(R.color.black));
                }
                else {
                    Showrightans();
                    binding.option1Con.setBackgroundResource(R.drawable.wrong_bg);
                    binding.option1Con.setTextColor(getContext().getColor(R.color.black));
                }
                Disableoption();
                binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
            }


        });

        binding.option2Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.equals(quizModel.getOp2(),quizModel.getCorrectAns())){
                    right++;
                    binding.option2Con.setBackgroundResource(R.drawable.new_right_bg);
                    binding.option2Con.setTextColor(getContext().getColor(R.color.black));
                }
                else {
                    Showrightans();
                    binding.option2Con.setBackgroundResource(R.drawable.wrong_bg);
                    binding.option2Con.setTextColor(getContext().getColor(R.color.black));

                }
                Disableoption();
                binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
            }

        });

        binding.option3Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.equals(quizModel.getOp3(),quizModel.getCorrectAns())){
                    right++;
                    binding.option3Con.setBackgroundResource(R.drawable.new_right_bg);
                    binding.option3Con.setTextColor(getContext().getColor(R.color.black));

                }
                else {
                    Showrightans();
                    binding.option3Con.setBackgroundResource(R.drawable.wrong_bg);
                    binding.option3Con.setTextColor(getContext().getColor(R.color.black));

                }
                Disableoption();
                binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
            }

        });

        binding.option4Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Objects.equals(quizModel.getOp4(),quizModel.getCorrectAns())){
                    right++;
                    binding.option4Con.setBackgroundResource(R.drawable.new_right_bg);
                    binding.option4Con.setTextColor(getContext().getColor(R.color.black));

                }
                else {
                    Showrightans();
                    binding.option4Con.setBackgroundResource(R.drawable.wrong_bg);
                    binding.option4Con.setTextColor(getContext().getColor(R.color.black));

                }
                Disableoption();
                binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
            }

        });
    }

    private void Showrightans() {

        if(Objects.equals(quizModel.getOp1(),quizModel.getCorrectAns())){
            binding.option1Con.setBackgroundResource(R.drawable.rightopbg);
            binding.option1Con.setTextColor(getContext().getColor(R.color.black));

        }
        else if(Objects.equals(quizModel.getOp2(),quizModel.getCorrectAns())){
            binding.option2Con.setBackgroundResource(R.drawable.rightopbg);
            binding.option2Con.setTextColor(getContext().getColor(R.color.black));

        }
        else if(Objects.equals(quizModel.getOp3(),quizModel.getCorrectAns())){
            binding.option3Con.setBackgroundResource(R.drawable.rightopbg);
            binding.option3Con.setTextColor(getContext().getColor(R.color.black));

        }
        else if(Objects.equals(quizModel.getOp4(),quizModel.getCorrectAns())){
            binding.option4Con.setBackgroundResource(R.drawable.rightopbg);
            binding.option4Con.setTextColor(getContext().getColor(R.color.black));

        }

    }
    public void Disableoption(){
        binding.option1Con.setEnabled(false);
        binding.option2Con.setEnabled(false);
        binding.option3Con.setEnabled(false);
        binding.option4Con.setEnabled(false);
        binding.nextBtn.setEnabled(true);
    }
}