# Test level fixtures

These files are used only by the academic JUnit tests. The playable levels in `assets/levels` remain unchanged.

- `levels/level1.txt`: a 26 by 8 board with four ghosts, energizers and a life at (24, 6). Based on the existing `assets/levels/level3.txt` board, with the life restored at the position required by the tests.
- `levels/level2.txt`: an 8 by 8 board with a single dot immediately to the right of Pacman. Based on the existing small `assets/levels/level1.txt` board, reduced to one collectible to exercise level completion after one move.

The original tests refer to these scenarios by filename and assert exact positions. Keeping dedicated copies here prevents changes to playable maps from silently changing the meaning of the tests.

The original academic test assertions and author attributions are preserved. These test fixtures and build corrections were prepared with AI assistance on 20 October 2026.
