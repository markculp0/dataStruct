# =====================
# Hash computation in R
# =====================
# "Hell0", m=5 => 4
# "world", m=5  => 4
# "GooD", m=5 => 2
# "luck", m=5 => 2


options(scipen = 999)

m <- 5
word <- "GooD"

word <- sapply(strsplit(word, NULL)[[1L]], utf8ToInt)
i <- 0
for (d in word ) {
  word[i + 1] <- word[i + 1] * 263^i
  i <-  i + 1
}
total <- sum(word)
hash <- total %% 1000000007
hash <- hash %% m

