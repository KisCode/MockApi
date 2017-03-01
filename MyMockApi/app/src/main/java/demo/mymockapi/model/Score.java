package demo.mymockapi.model;

public class Score{
        private float mathScore;
        private float englishScore;
        public float getMathScore() {
            return mathScore;
        }

        public void setMathScore(float mathScore) {
            this.mathScore = mathScore;
        }

        public float getEnglishScore() {
            return englishScore;
        }

        public void setEnglishScore(float englishScore) {
            this.englishScore = englishScore;
        }

    @Override
    public String toString() {
        return "Score{" +
                "mathScore=" + mathScore +
                ", englishScore=" + englishScore +
                '}';
    }
}