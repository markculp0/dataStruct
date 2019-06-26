
# ========================================

# h("world")
119 + (111 * 263) + (114 * 263^2) + (108 * 263^3) + (100 * 263^4)
# [1] 480407646954

480407646954 %% 1000000007
# [1] 407643594

407643594 %% 5
# [1] 4

# ========================================

# java
# char character = 'a';    
# int ascii = (int) character;

# char character = name.charAt(0); // This gives the character 'a'
# int ascii = (int) character; // ascii is now 97.

# R computation

utf8ToInt("w")
# [1] 119

world <- sapply(strsplit("world", NULL)[[1L]], utf8ToInt)
#   w   o   r   l   d 
# 119 111 114 108 100 

m <- 5
i <- 0
for (d in world ) {
  world[i + 1] <- world[i + 1] * 263^i
  i <-  i + 1
}
t1 <- sum(world)
# [1] 480407646954
t1 <- t1 %% 1000000007
t1 <- t1 %% m

# ========================================


